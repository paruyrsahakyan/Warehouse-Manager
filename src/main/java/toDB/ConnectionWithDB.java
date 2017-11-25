package toDB;

import BasicNames.Name;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionWithDB {

    private String driverName = Name.DRIVER_NAME;
    private String url = Name.URL;
    private String user = Name.USER;
    private String password = Name.PASSWORD;
    private Connection conn;
    private Statement statement;

    public void setConnection() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            conn = DriverManager.getConnection(url, user, password); //installing driver
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void closeConnection() {
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }


}
