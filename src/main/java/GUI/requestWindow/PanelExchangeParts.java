package GUI.requestWindow;

import SQL.QueryFactory;
import toDB.ConnectionWithDB;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PanelExchangeParts extends JPanel{
    private JTable table;
    WindowPartsRequest windowPartsRequest;
    JScrollPane jScrollPane;

  public   PanelExchangeParts(WindowPartsRequest windowPartsRequest) {
      this.windowPartsRequest = windowPartsRequest;

      table = new JTable();
      this.jScrollPane = new JScrollPane(table);

        this.setPreferredSize(new Dimension(150,150));
         Border innerBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);
         Border outerBorder = BorderFactory.createTitledBorder("Exchangeable Parts");
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
        this.setLayout( new BorderLayout());
        this.add(jScrollPane, BorderLayout.CENTER);

        table.addMouseListener(new ListenerExchangeTable(windowPartsRequest, table));
    }

    public void setTable(ArrayList<RequestedPart> partsList) throws SQLException {

        String[] columnNames = {"Part Number", "Req. Quantity",
            "Can take", "Available in warehouse", "Unit", "Part Name", "Last Income Date"};

        ConnectionWithDB connectionWithDB= ConnectionWithDB.getInstance();
        Statement statement = connectionWithDB.getStatement();

        QueryFactory queryFactory = new QueryFactory();
        System.out.println(queryFactory.partsRequest(partsList));
        ResultSet resultSet = statement.executeQuery(queryFactory.partsRequest(partsList));

        ResultAndRequest resultAndRequest = new ResultAndRequest();
        Object[][] parts = resultAndRequest.compareToRequest(partsList, resultSet);

        DefaultTableModel defaultTableModel = new DefaultTableModel(parts, columnNames);

        this.table.setModel(defaultTableModel);


        windowPartsRequest.setVisible(true);


    }
    public void setEmptyTable() {
        String[] columnNames = {"Part Number", "Req. Quantity",
                "Can take", "Available in warehouse", "Unit", "Part Name", "Last Income Date"};
        String[][] parts = new String[1][7];

      DefaultTableModel emptyModel = new DefaultTableModel(parts, columnNames);

     this.table.setModel(emptyModel);
        this.table.setCellSelectionEnabled(false);
}

    public JTable getTable() {
        return table;
    }
}


