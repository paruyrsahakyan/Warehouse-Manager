package SQL;

import BasicNames.Name;
import GUI.requestWindow.RequestedPart;
import xlsParser.Action;
import xlsParser.PartInStock;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class QueryFactory {

    private String actionTableName;
    private String partTableName;
    private String dbName;

    public  QueryFactory(){
        this.actionTableName = Name.ACTIONS_TABLE_NAME;
        this.partTableName = Name.PARTS_TABLE_NAME;
        this.dbName = Name.DB_NAME;
//        Connection connection;
//
//        try {
//            Class.forName(Name.DRIVER_NAME);
//                   } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(Name.URL, Name.USER, Name.PASSWORD);
//            Statement statement = connection.createStatement();
//             } catch (SQLException e) {
//            e.printStackTrace();
//        }
//

    }

////////////////////////  CREATE TABLE FOR PARTS IN STOCK ////////////////////
    /*
            Creates a query for adding a table  into  database "warehousedb".
            Argument is an instance of class PartInStock.
            This method is overloaded.
            Before using this method you should set tableName.
    */
    public String tableOfParts() {
        return  ("CREATE TABLE `warehousedb`.`"+partTableName+"` (\n" +
                "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `last_income_date` DATE NOT NULL,\n" +
                " `partNumber` VARCHAR(150) NOT NULL,\n" +
                " `unit` VARCHAR(150) NOT NULL,\n"+
                " `quantity` int NOT NULL,\n"+
                " `partName` VARCHAR (150) NOT NULL,\n"+
                "  PRIMARY KEY (`ID`));\n")  ;
    }
///////////////////////// CREATE TABLE OF ACTIONS /////////////////
/*
            Creates a query for adding a table  into  database "warehousedb".
            Argument is an instance of class ACTION.
            This method is overloaded.
            Before using this method you should set tableName.
    */

public String tableOfActions() {

    return  ("CREATE TABLE `warehousedb`.`"+actionTableName+"` (\n" +
            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `date` DATE NOT NULL,\n" +
            "  `in_out` VARCHAR(45) NOT NULL,\n" +
            " `partNumber` VARCHAR(150) NOT NULL,\n" +
            " `unit` VARCHAR(150) NOT NULL,\n"+
            " `quantity` int NOT NULL,\n"+
            " `partName` VARCHAR (150) NOT NULL,\n"+
            "  PRIMARY KEY (`ID`));\n");
}

////////////////////////  INSERT QUERY OF AN  ACTION ////////////
    public String actionInsertQuery(Action action) {
//    Double quantity = getQuantity();
        return "INSERT INTO " + "warehousedb" + "." + actionTableName +
                "(date, in_out, partNumber, unit, quantity, partName) " +
                "VALUES ( '" +
                action.getDateInSQLFormat() + "','" +
                action.getIn_out() + "','" +
                action.getPartNumber() + "','" +
                action.getUnit() + "','" +
                String.valueOf(action.getQuantity()) + "','" +
                action.getPartName() + "')";
    }

    ////////////////////////  INSERT QUERY OF A PART ////////////
    public String partInsertQuery(PartInStock part) {
//    Double quantity = getQuantity();
        return "INSERT INTO " + "warehousedb" + "." + partTableName +
                "(last_income_date, partNumber, unit, quantity, partName) " +
                "VALUES ( '" +
                part.getDateInSQLFormat() + "','" +
                part.getPartNumber() + "','" +
                part.getUnit() + "','" +
                String.valueOf(part.getQuantity()) + "','" +
                part.getPartName() + "')";
    }

    ////////////////////////   PARTS REQUEST QUERY   ///////////////

    public String partsRequest(ArrayList<RequestedPart> partsList) {

        int partsQuantity = partsList.size();
        String currentPartNumber;
        currentPartNumber = partsList.get(0).getPartNumber();
        String query = "SELECT * FROM " + dbName + "." +partTableName+
                 " where partNumber =" + " '" +currentPartNumber+ "' ";

        for (int i = 1; i < partsQuantity; i++) {
            currentPartNumber = partsList.get(i).getPartNumber();
            query = query + "or partNumber =" + " '" + currentPartNumber +"' ";
        }
        query = query + ";";
        return query;

    }




}