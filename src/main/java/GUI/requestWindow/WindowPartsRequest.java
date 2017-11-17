package GUI.requestWindow;

        import javax.swing.*;
        import java.awt.*;
        import java.util.ArrayList;

public class WindowPartsRequest extends JFrame {

    private PanelRequestParts panelRequestParts;
    private PanelResult panelResult;
    private ArrayList<DynamicTextFields> listTextField;
    private int partsQuantity;

    public WindowPartsRequest() {
        partsQuantity = 0;
        panelRequestParts = new PanelRequestParts(this);
        panelResult = new PanelResult(this);
        listTextField = new ArrayList<DynamicTextFields>();

        this.setTitle("PartsRequest");
        this.setLocationByPlatform(true);
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.add(panelRequestParts, BorderLayout.WEST);
        this.add(panelResult, BorderLayout.CENTER);
        this.setVisible(true);
        //        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void addTextField() {
        listTextField.add(new DynamicTextFields(this));

        this.panelRequestParts.add(listTextField.get(partsQuantity));
        partsQuantity++;
    }

    public void showRequestResult(ArrayList<String> parts) {
        this.panelResult.showResult(parts);
    }

      public  ArrayList<String > getRequestedParts() {
        return this.panelRequestParts.getPartsList();
    }


}

