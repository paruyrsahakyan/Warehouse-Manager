package SQL;

import BasicNames.Name;
import GUI.requestWindow.RequestedPart;
import xlsParser.Action;
import xlsParser.PartInStock;

import java.sql.*;
import java.util.ArrayList;

public class QueryFactory {

    private String actionTableName;
    private String partTableName;
    private String dbName;
    private String exchangeTableName;

    public QueryFactory() {
        this.actionTableName = Name.ACTIONS_TABLE_NAME;
        this.partTableName = Name.PARTS_TABLE_NAME;
        this.dbName = Name.DB_NAME;
        this.exchangeTableName = Name.EXCHANGEABLE_TABLE_NAME;
    }

    ////////////////////////////  CREATE TABLE FOR PARTS IN STOCK ///////////
    /*
            Creates a query for adding a table  into  database "warehousedb".
            Argument is an instance of class PartInStock.
            This method is overloaded.
            Before using this method you should set tableName.
    */

    public String tableOfParts() {
        return ("CREATE TABLE `warehousedb`.`" + partTableName + "` (\n" +
                "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `last_income_date` DATE NOT NULL,\n" +
                " `partNumber` VARCHAR(150) NOT NULL,\n" +
                " `unit` VARCHAR(150) NOT NULL,\n" +
                " `quantity` int NOT NULL,\n" +
                " `partName` VARCHAR (150) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`));\n");
    }

    ///////////////////////// CREATE TABLE OF ACTIONS //////////////////////
/*
            Creates a query for adding a table  into  database "warehousedb".
            Argument is an instance of class ACTION.
            This method is overloaded.
            Before using this method you should set tableName.
    */
    public String tableOfActions() {

        return ("CREATE TABLE `warehousedb`.`" + actionTableName + "` (\n" +
                "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `date` DATE NOT NULL,\n" +
                "  `in_out` VARCHAR(45) NOT NULL,\n" +
                " `partNumber` VARCHAR(150) NOT NULL,\n" +
                " `unit` VARCHAR(150) NOT NULL,\n" +
                " `quantity` int NOT NULL,\n" +
                " `partName` VARCHAR (150) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`));\n");
    }

    /////////////////////// CREATE TABLE OF EXCHANGEABLE PARTS ///////////////
    public String tableOfExchange() {
        return ("CREATE TABLE `warehousedb`.`" + exchangeTableName + "` (\n" +
                "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `exchange1` VARCHAR(150) NULL,\n" +
                " `exchange2` VARCHAR(150)  NULL,\n" +
                " `exchange3` VARCHAR(150)  NULL,\n" +
                " `exchange4` VARCHAR(150)  NULL,\n" +
                " `exchange5` VARCHAR(150)  NULL,\n" +
                " `exchange6` VARCHAR(150)  NULL,\n" +
                " `exchange7` VARCHAR(150)  NULL,\n" +
                " `exchange8` VARCHAR(150)  NULL,\n" +
                "  PRIMARY KEY (`ID`));\n");
    }

    ////////////////////////  INSERT QUERY OF AN  ACTION /////////////////////
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

    ////////////////////////  INSERT QUERY OF A PART /////////////////////////
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

    ////////////////////////   PARTS REQUEST QUERY   /////////////////////////
    public String partsRequest(ArrayList<RequestedPart> partsList) {

        int partsQuantity = partsList.size();
        String currentPartNumber;
        currentPartNumber = partsList.get(0).getPartNumber();
        String query = "SELECT * FROM " + dbName + "." + partTableName +
                " where partNumber in (" + " '" + currentPartNumber + "' ";

//                " where partNumber =" + " '" + currentPartNumber + "' ";

        for (int i = 1; i < partsQuantity; i++) {
            currentPartNumber = partsList.get(i).getPartNumber();
            query = query +  ", '" + currentPartNumber + "' ";
//            query = query + "or partNumber =" + " '" + currentPartNumber + "' ";
        }
        query = query + ");";
        return query;

    }

    ////////////////////// FIND EXCHANGEABLE PARTS ////////////////////////////
    public String findExchangeable(ArrayList<String> partsList) {

        int size = partsList.size();
        String currentPartNumber;
        currentPartNumber = partsList.get(0);
        String result = "SELECT * FROM " + dbName + "." + exchangeTableName +
                " where ";
        for (int j = 1; j < 8; j++) {
            result = result + " exchange" + j + " in (";
            for (int i = 0; i < size - 1; i++) {
                result = result + " '" + partsList.get(i) + "', ";
            }
            if (j != 7) {
                result = result + "'" + partsList.get(size - 1) + "') " + "or ";
            } else {
                result = result + "'" + partsList.get(size - 1) + "');";
            }
        }

        return result;
    }

    //////////////////////  ADD NEW EXCHANGEABLE ROW ///////////////////////////
    public String addExchangeableRow(ArrayList<String> partsList) {
        int size = partsList.size();

        String result = "INSERT INTO " + "warehousedb" + "." + exchangeTableName + " (";
        for (int k = 1; k < size; k++) {
            result = result + "exchange" + k + ", ";
        }
        result = result + "exchange" + size + ") " + "VALUES (";
        for (int k = 0; k < size - 1; k++) {
            result = result + " '" + partsList.get(k) + "', ";
        }
        result = result + " '" + partsList.get(size - 1) + "'); ";
        return result;
    }

    ///////////////////// ADD EXCHANGEABLE PARTS /////////////////////////////////
    public void addExchangeableParts(Statement statement, ResultSet resultSet, ArrayList<String> arrayList) throws SQLException {
        ArrayList<String> partList = new ArrayList<String>();
        boolean allreadyExist;
        for (int g = 0; g < arrayList.size(); g++) {
            allreadyExist = false;
            for (int j = 2; j < 9; j++) {
                if (arrayList.get(g).equals(resultSet.getString(j))) {
                    allreadyExist = true;
                    break;
                }
            }
            if (!allreadyExist) {
                partList.add(arrayList.get(g));
            }
        }
        int id = resultSet.getInt(1);
        String query;
        int arrayListCursor = -1;
        int i;
        for (i = 2; i < 9; i++) {
            if (resultSet.getString("exchange" + i) == null) {
                arrayListCursor++;
                break;
            }
        }

        while (arrayListCursor < partList.size()) {
            query = "UPDATE " + "warehousedb" + "." + exchangeTableName + " SET " +
                    "exchange" + i + "=" + "'" + partList.get(arrayListCursor) + "'  " +
                    " where ID=" + id + ";";
            i++;
            arrayListCursor++;
            System.out.println(query);
            statement.execute(query);
        }
    }
}
