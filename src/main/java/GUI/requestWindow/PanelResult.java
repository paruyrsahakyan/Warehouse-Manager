package GUI.requestWindow;

import BasicNames.Name;
import SQL.QueryFactory;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class PanelResult extends JPanel {
    private JTable table;
    private QueryFactory query;
    private WindowPartsRequest windowPartsRequest;

    PanelResult(WindowPartsRequest windowPartsRequest) {

        this.windowPartsRequest = windowPartsRequest;
        this.setLayout(new BorderLayout());
    }

    public void showResult(ArrayList<String> partsList) {
        String[] columnNames = {"Part Number", "Available", "Can Take"};

        ////////////////////////////

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

            int matchedPartsQuantity = 0;
            while (resultSet.next()) {matchedPartsQuantity++;}

            Object parts[][] = new Object[matchedPartsQuantity][3];
            resultSet.beforeFirst();
            int k = 0;

            while (resultSet.next()) {

                parts[k][0] = resultSet.getString(3);
                parts[k][1] = resultSet.getInt(5);
                parts[k][2] = resultSet.getInt(5);
                k++;

            }

            this.table = new JTable(parts, columnNames);
            this.add(table, BorderLayout.CENTER);
            windowPartsRequest.setVisible(true);
            statement.close(); connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }
