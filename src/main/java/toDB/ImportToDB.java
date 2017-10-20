package toDB;

import xlsParser.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
public class ImportToDB {
    private  final String DBname = "warehousedb" ;
    private  final String tableName = "action";
    private  final String user = "root";
    private  final String password = "729326";
    private  final String url = "jdbc:mysql://localhost:3306/"+DBname+"?autoReconnect=true&useSSL=false";
    private  final String driverName = "com.mysql.cj.jdbc.Driver";

/////////////////////////// IMPORT ACTIONS///////////////////////////////////////////
    public  void importActions(ArrayList<Action> actionList)  {
              try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
                Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            Iterator itr = actionList.iterator();
            Action currentAction;
//              stmt.addBatch("DELETE FROM werehousedb.test");
//            stmt.addBatch("ALTER TABLE werehousedb.test AUTO_INCREMENT = 0;");
               int k=0;
            while (itr.hasNext()) {
                currentAction = (Action) itr.next();
                String currentSQL = currentAction.createInsertQuery(DBname+"."+tableName);
                stmt.execute(currentSQL);
                k++;
                System.out.println(k+ " imported");
                            }
            stmt.close();
            conn.close();
            if (conn.isClosed())
            {
                System.out.println("point5");
                System.out.println("conn is closed");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

////////////////////////////CREATE TABLE//////////////////////////
    public  void createTable( String tableName){
                try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
                   stmt.execute("CREATE TABLE `warehousedb`.`"+tableName+"` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `date` DATE NOT NULL,\n" +
                    "  `in_out` VARCHAR(45) NOT NULL,\n" +
                    " `partNumber` VARCHAR(150) NOT NULL,\n" +
                    " `unit` VARCHAR(150) NOT NULL,\n"+
                    " `quantity` int NOT NULL,\n"+
                    " `partName` VARCHAR (150) NOT NULL,\n"+
                    "  PRIMARY KEY (`ID`));\n");
            stmt.close();
            conn.close();}
    catch (SQLException e) {
                e.printStackTrace();
            }
        }
}