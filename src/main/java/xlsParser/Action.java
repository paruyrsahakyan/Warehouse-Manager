package xlsParser;

import BasicNames.Name;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Action {

    ///////////////////// FIELDS /////////////////////
    private Date   date;         // 0 column
    private String in_out;         // 1
    private String partNumber;  //  2
    private String unit;        //  3
    private double quantity;    //  4
    private String partName;    //  5
    private String actionsTableName;
    private String partsTableName;


    ///////////////Empty Constructor /////////////

    public Action() {
        this.actionsTableName = Name.ACTIONS_TABLE_NAME;
        this.partsTableName = Name.PARTS_TABLE_NAME;

    }

    ////////////// CLONE CONSTRACTOR //////////////

    public Action(Action action) {
        this.date = action.date;
        this.in_out = action.in_out;
        this.partNumber = action.partNumber;
        this.unit = action.unit;
        this.quantity = action.quantity;
        this.partName = action.partName;
    }

    ///////////  SETTERS/   //////////////////////////
    public void setDate(Date date2) {
        date = date2;
    }

    public void setUnit(String un) {
        unit = un;
    }

    public void setIn_out(String in) {
        in_out = in;
    }

    public void setPartNumber(String pNumber) {
        partNumber = pNumber;
    }

    public void setPartName(String pName) {
        partName = pName;
    }

    public void setQuantity(double q) {
        quantity = q;
    }

    ///////////   GETTER      ////////////////////////////
    public Date getDate() {
        return date;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getPartName() {
        return partName;
    }

    public String getUnit() {
        return unit;
    }

    public String getIn_out() {
        return in_out;
    }

    public String getPartNumber() {
        return partNumber;
    }

    /////////////////  DATE FORMATIONG ////////////

    public String getDateInSQLFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(getDate());
    }

    ////////////////////TO STRING ///////////////////////

    public String toString() {

        return (getDateInSQLFormat() +
                " | " + getIn_out() + " | " +
                getPartNumber() + " | " +
                getQuantity() + " | " + getPartName());
    }

    /////////////get Insert Query/////////////////////////

        public String actionInsertQuery() {
        Double quantity = getQuantity();
        return "INSERT INTO " + "warehousedb"+"."+actionsTableName+
                "(date, in_out, partNumber, unit, quantity, partName) " +
                "VALUES ( '" +
                getDateInSQLFormat() + "','" +
                getIn_out() + "','" +
                getPartNumber() + "','" +
                getUnit() + "','" +
                quantity.toString() + "','" +
                getPartName() + "')";
    }


    //////////////// get PartInStock ////////////////////////

    public PartInStock getPartInStock() {
        PartInStock result = new PartInStock();
        result.setPartNumber(this.getPartNumber());
        result.setUnit(this.getUnit());
        result.setQuantity(this.getQuantity());
        result.setPartName(this.getPartName());
        result.setLastIncomeDate(this.getDate());
        return result;
    }
}