package GUI.ToolBar.windowMaintenance;

import GUI.requestWindow.RequestedPart;
import GUI.requestWindow.ResultAndRequest;
import SQL.QueryFactory;
import toDB.ConnectionWithDB;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class PanelResult extends JPanel {
    private JTable table;
    private WindowMaintenance windowMaintenance;
    private JScrollPane scrollpane;
    private DefaultTableModel defaultTableModel;

    public PanelResult(WindowMaintenance windowMaintenance) {
        this.table = new JTable();
        this.defaultTableModel = new DefaultTableModel();
        this.windowMaintenance = windowMaintenance;
        this.scrollpane = new JScrollPane(table);
        this.setPreferredSize(new Dimension(600, 400));
        Border innerBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        Border outerBorder = BorderFactory.createTitledBorder("Parts to take with");
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.setLayout(new BorderLayout());
        this.add(scrollpane, BorderLayout.CENTER);

        this.initTable();

    }

    public void showResult(ArrayList<RequestedPart> requestedParts) {

        ConnectionWithDB connectionWithDB =ConnectionWithDB.getInstance();
        Statement statement = connectionWithDB.getStatement();
        QueryFactory queryFactory = new QueryFactory();
        try {
            ResultSet resultSet = statement.executeQuery(queryFactory.partsRequest(requestedParts));
            ResultAndRequest resultAndRequest = new ResultAndRequest();
            Object[][] parts = resultAndRequest.compareToRequest(requestedParts, resultSet);
            for (Object[] objects : parts) {

                this.defaultTableModel.addRow(objects);
            }

            this.table.setBackground(Color.CYAN);

            windowMaintenance.setVisible(true);
            statement.close();
            connectionWithDB.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initTable() {
        this.defaultTableModel = new DefaultTableModel();
        String[] columnNames = {"Part Number", "Req. Quantity",
                "Can take", "Available in warehouse", "Unit", "Part Name", "Last Income Date"};
        defaultTableModel.setColumnIdentifiers(columnNames);

        this.table.setModel(defaultTableModel);
        this.table.getColumnModel().getColumn(1).setWidth(45);
        this.table.getColumnModel().getColumn(2).setWidth(40);
        this.table.getColumnModel().getColumn(3).setWidth(40);
        this.table.getColumnModel().getColumn(4).setWidth(20);
        this.table.getColumnModel().getColumn(6).setWidth(40);

        this.table.sizeColumnsToFit(40);

    }

    public void setNewMachineName(String machineName) {
        this.defaultTableModel.addRow(new Object[]{machineName});
    }
}


