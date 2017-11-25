package GUI.requestWindow;

import BasicNames.Name;
import SQL.QueryFactory;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class PanelResult extends JPanel {
    private JTable table;
    private WindowPartsRequest windowPartsRequest;
    private JScrollPane scrollpane;

    PanelResult(WindowPartsRequest windowPartsRequest) {

        this.windowPartsRequest = windowPartsRequest;
        this.setLayout(new BorderLayout());
        this.table = new JTable();
        this.scrollpane = new JScrollPane(table);
        Border innerBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);
        Border outerBorder = BorderFactory.createTitledBorder("Request Result");
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.add(scrollpane, BorderLayout.CENTER);

    }

    public void showResult(ArrayList<RequestedPart> partsList) {
        String[] columnNames = {"Part Number", "Req. Quantity",
                "Can take", "Available in warehouse", "Unit", "Part Name", "Last Income Date"};

        Connection connection;
        try {
            Class.forName(Name.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(Name.URL, Name.USER, Name.PASSWORD);
            Statement statement = connection.createStatement();

            QueryFactory queryFactory = new QueryFactory();
            System.out.println(queryFactory.partsRequest(partsList));
            ResultSet resultSet = statement.executeQuery(queryFactory.partsRequest(partsList));

            ResultAndRequest resultAndRequest = new ResultAndRequest();
            Object[][] parts = resultAndRequest.compareToRequest(partsList, resultSet);

            DefaultTableModel defaultTableModel = new DefaultTableModel(parts, columnNames);

            this.table.setModel(defaultTableModel);


//            this.add(table, BorderLayout.CENTER);

            windowPartsRequest.setVisible(true);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
