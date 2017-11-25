package xlsParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class PartInStock {

    private Date LastIncomeDate = null;
    private String partNumber;
    private String unit;
    private double quantity;
    private String partName;

   public PartInStock() {
        this.LastIncomeDate = new Date();
        this.partNumber = new String();
        this.unit = new String();
        this.partName = new String();

    }
    //////////////// DATE IN SQL FORMAT////////////////////////////////////

    public String getDateInSQLFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(getLastIncomeDate());
    }

    ///////////////////// TO STRING//////////////////////////////////////////////
    public  String toString () {
                 return (getDateInSQLFormat() + " | " +
                getPartNumber() + " | " +
                getUnit() + "|" +
                getQuantity() + " | " +
                getPartName()+"\n") ;
             }

    //////////////////////// CREATE LIST OF PARTINSTOCK ///////////////////////////////////

    public ArrayList<PartInStock>  buildListOfPartInStok(ArrayList<Action> actionList) {
        ArrayList<PartInStock> result = new ArrayList<PartInStock>();
        String actionPartNumber;
        String inStockPartNumber;
        Iterator<Action> itrAction = actionList.iterator();

        Action currentAction = new Action();
        PartInStock currentPartInStock = new PartInStock();
        while (itrAction.hasNext()) {
            currentAction = itrAction.next();
            actionPartNumber = currentAction.getPartNumber();

            Iterator<PartInStock> itrResult = result.iterator();
            Boolean alreadyExist = false;
            while (itrResult.hasNext()) {
                currentPartInStock = itrResult.next();
                inStockPartNumber = currentPartInStock.getPartNumber();

                if (actionPartNumber.equals(inStockPartNumber)) {
                    alreadyExist = true;
                    double currentPartsQuantity = currentPartInStock.getQuantity();
                    if (currentAction.getIn_out().equals("Вход")) {
                        currentPartInStock.setQuantity(currentPartsQuantity + currentAction.getQuantity());
                        currentPartInStock.setLastIncomeDate(currentAction.getDate());
                        break;
                    } else {
                        currentPartInStock.setQuantity(currentPartsQuantity - currentAction.getQuantity());
                        break;
                    }
                }

            }
            if (!alreadyExist) {
                PartInStock newPartInStock = currentAction.getPartInStock();
                result.add(newPartInStock);
            }
        }
        return result;
    }

    /////////////////////// GETTERS AND SETTERS ///////////////////////////////////

    public Date getLastIncomeDate() { return LastIncomeDate; }

    public void setLastIncomeDate(Date date) {this.LastIncomeDate = date; }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
}


////////////////////////  SQL CREATE TABLE ////////////////////////////////////////////