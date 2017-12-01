package GUI.requestWindow;

        import javax.swing.*;
        import java.awt.*;
        import java.util.ArrayList;

public class WindowPartsRequest extends JFrame {

    private PanelRequestParts panelRequestParts;
    private PanelResult panelResult;
    private ArrayList<DynamicTextFields> listTextField;
    private int partCursor;
    private PanelExchangeParts panelExchangeParts;
    private boolean exchangeTableEmpty;

    public WindowPartsRequest() {
        partCursor = -1;
        panelRequestParts = new PanelRequestParts(this);
        panelResult = new PanelResult(this);
        panelExchangeParts = new PanelExchangeParts(this);
        listTextField = new ArrayList<DynamicTextFields>();


        this.setTitle("PartsRequest");
        this.setLocationByPlatform(true);
        this.setSize(1150, 400);
        this.setLayout(new BorderLayout());
        this.add(panelRequestParts, BorderLayout.WEST);
        this.add(panelResult, BorderLayout.CENTER);
        this.add(panelExchangeParts, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    public void addTextField() {
        listTextField.add(new DynamicTextFields(this)); // adding a new DynamicTextFields() into Arraylist ,it  to make possible to refer that  DynamicTextField further;
        partCursor++; //  this variable  serves as a cursor, for referring the DynamicTextField that we added into Array list.
        this.panelRequestParts.add(new JLabel("p/n"));  // before adding a Dynamic text field to the window we add a label "p/n".
        this.panelRequestParts.add(listTextField.get(partCursor)); //we add the DynamicTextField to the window, which was created 2 rows above, and wich was added into Array list;
        this.panelRequestParts.getListTextField().add(this.listTextField.get(partCursor)); //this for adding that DynamicTextField into special ArrayList of panelRequestParts, for further usage.
        this.panelRequestParts.add(new JLabel("    q.-ty")); //before adding a Dynamic text field to the window we add a label "q.-ty".
        this.panelRequestParts.add(listTextField.get(partCursor).getQuantityTextField()); //adding text field  of parts quantity, this text field is a defined in DynamicTextField "field of Dy..." ;

    }

    public PanelResult getPanelResult() {
        return panelResult;
    }

    public PanelExchangeParts getPanelExchangeParts() {
        return panelExchangeParts;
    }

    public  ArrayList<RequestedPart > getRequestedParts() {
        return this.panelRequestParts.getPartsList();
    }



    public boolean isExchangeTableEmpty() {
        return exchangeTableEmpty;
    }

    public void setExchangeTableEmpty(boolean exchangeTableEmpty) {
        this.exchangeTableEmpty = exchangeTableEmpty;
    }
}

