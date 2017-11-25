package GUI.ToolBar.windowMaintenance.TM;


public class TMPart {
    private String partNumber;
    private int quantity;
    private String description;
    private String fluidOrSolid;

    public TMPart(String partNumber, int quantity) {
        this.partNumber = partNumber;
        this.quantity = quantity;
    }

    public String getFluidOrSolid() {
        return fluidOrSolid;
    }

    public void setFluidOrSolid(String fluidOrSolid) {
        this.fluidOrSolid = fluidOrSolid;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

