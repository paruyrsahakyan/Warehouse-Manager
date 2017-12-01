package GUI.requestWindow;

import BasicNames.Name;
import SQL.QueryFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class TableBuilder {


    public void  buildTableFromReqParts(WindowPartsRequest windowPartsRequest, JPanel jPanel, ArrayList<RequestedPart> partsList){
JTable table= new JTable();
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

            table.setModel(defaultTableModel);

            table.addMouseListener(new ListenerTable(windowPartsRequest, table));


//            this.add(table, BorderLayout.CENTER);

            windowPartsRequest.setVisible(true);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

