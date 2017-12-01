package GUI.MenuBar.ExchangeableParts;

import SQL.QueryFactory;
import toDB.ConnectionWithDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListenerButtonSave implements ActionListener {

    private WinExchangeableParts winExchangeableParts;

    ListenerButtonSave(WinExchangeableParts winExchangeableParts) {
        this.winExchangeableParts = winExchangeableParts;

    }

    public void actionPerformed(ActionEvent e) {
        Component[] components = winExchangeableParts.getRootPane().getContentPane().getComponents();
        ArrayList<String> arrayList = new ArrayList<String>();

        for (Component component : components) {
            if (component.getClass().getName().endsWith("JTextField")) {
                JTextField jTextField = (JTextField) component;
                if (!jTextField.getText().equals("")) {
                    arrayList.add(jTextField.getText());
                }
            }
        }
        ConnectionWithDB connectionWithDB = ConnectionWithDB.getInstance();
        Statement statement = connectionWithDB.getStatement();
        QueryFactory queryFactory = new QueryFactory();
        String query = queryFactory.findExchangeable(arrayList);
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            if(!resultSet.next()) {
               statement.execute(queryFactory.addExchangeableRow(arrayList));
                winExchangeableParts.setVisible(false);
            }
            else {
                queryFactory.addExchangeableParts(statement, resultSet, arrayList);
                winExchangeableParts.setVisible(false);

            }


        } catch (SQLException e1) {
            e1.printStackTrace();
        }

            }
}
