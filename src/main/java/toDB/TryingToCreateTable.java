package toDB;

import xlsParser.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
public class TryingToCreateTable{
    private static final String user = "root";
    private static final String password = "729326";
    private static final String url = "jdbc:mysql://localhost:3306/warehousedb?autoReconnect=true&useSSL=false";
    public  static void main(String args[]) throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE `warehousedb`.`action` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `date` DATE NOT NULL,\n" +
                    "  `in_out` VARCHAR(45) NOT NULL,\n" +
                    " `partNumber` VARCHAR(45) NOT NULL,\n" +
                    " `unit` VARCHAR(45) NOT NULL,\n"+
                    " `quantity` int NOT NULL,\n"+
                    " `partName` int NOT NULL,\n"+
                    "  PRIMARY KEY (`ID`));\n");
            stmt.close();
            conn.close();
            if (conn.isClosed())
            {
                System.out.println("conn is closed");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}