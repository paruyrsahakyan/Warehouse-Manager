package GUI.requestWindow;

import java.util.ArrayList;
import java.util.Iterator;

public class RequestedPart {
    private String partNumber;
    private double quantity;

    public RequestedPart(){
        
    }
   public RequestedPart(String partNumber, double quantity){
        this.partNumber = partNumber;
        this.quantity = quantity;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public static ArrayList<String> getOnlyPartNumbers(ArrayList<RequestedPart> requestedParts) {
        ArrayList<String> result = new ArrayList<String>();
        Iterator<RequestedPart> iterator = requestedParts.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next().getPartNumber());
        }
        return result;
    }
}