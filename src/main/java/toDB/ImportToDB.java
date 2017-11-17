package toDB;

import BasicNames.Name;
import SQL.QueryFactory;
import xlsParser.*;
import xlsParser.Action;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
public class ImportToDB {

    private  final String DBname = "warehousedb" ;
//    private  String actionsTableName = "actions";
//    private  String partsTableName = "parts";
    private  String user;    /// = "root";
    private  String password;     //= "729326";
    private  String url; // = "jdbc:mysql://localhost:3306/"+DBname+"?autoReconnect=true&useSSL=false";
    private  String driverName; // = "com.mysql.cj.jdbc.Driver";
    private JProgressBar progressBar;


    ///////////////////////////CONSTRUCTOR /////////////////////////////////////

    public ImportToDB() {
        this.user = Name.USER;
        this.password = Name.PASSWORD;
        this.url = Name.URL;
        this.driverName = Name.DRIVER_NAME;
                        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /////////////////////////// IMPORT ACTIONS///////////////////////////////////////////

public void importActionsAndParts(ArrayList<Action> actionList) {

    Connection conn;
    try {
        conn = DriverManager.getConnection(url, user, password); //installing driver
        Statement stmt = conn.createStatement();
        Iterator actionItr = actionList.iterator();
        Action currentAction;
            int k = 0;
//        progressBar.setMinimum(0);
//        progressBar.setMaximum(1000);

            while (actionItr.hasNext()) {
                currentAction = (Action) actionItr.next(); // geting the next action
                QueryFactory query = new QueryFactory();                      //
                String currentSQL = query.actionInsertQuery(currentAction);  //creating query for adding current action
                 stmt.execute(currentSQL);
                k++;
//                progressBar.setValue( k);

                System.out.println(k + " action");   // just for visualization of importing process.
            }

                PartInStock partInStock = new PartInStock();
                ArrayList<PartInStock> parts = partInStock.buildListOfPartInStok(actionList); // builds list of parts from the list of actions.
                Iterator partItr = parts.iterator();
                PartInStock currentPart;
                 k = 0;
                while (partItr.hasNext()) {
                    currentPart = (PartInStock) partItr.next();
                    QueryFactory query = new QueryFactory();
                    String currentSQL = query.partInsertQuery(currentPart);
                    stmt.execute(currentSQL);
                    k++;
                    System.out.println(k + " part");
            }
            stmt.close();
            conn.close();
            if (conn.isClosed()) {
               System.out.println("conn is closed");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


//////////////////////////// CREATE TABLES //////////////////////////
    public  void createTables( ) {
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            QueryFactory query = new QueryFactory();
            stmt.execute(query.tableOfActions());
            stmt.execute(query.tableOfParts());
            stmt.close();
            conn.close();}
    catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void setProgressBar(JProgressBar jProgressBar){
        this.progressBar = jProgressBar;
        }


}