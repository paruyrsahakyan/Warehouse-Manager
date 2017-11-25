package GUI.requestWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class PanelRequestParts extends JPanel {

    private DynamicTextFields dynamicTextFields;
    private JButton buttonRequest;
    private JButton buttonAdd;
    private WindowPartsRequest windowPartsRequest;
    private ArrayList<DynamicTextFields> listTextField;
    private int partsQuantity;

    public PanelRequestParts(WindowPartsRequest windowPartsRequest) {

        buttonRequest = new JButton("Execute Request");
        listTextField = new ArrayList<DynamicTextFields>();
        partsQuantity = 0;

        this.windowPartsRequest = windowPartsRequest;

        this.setPreferredSize(new Dimension(295, 400));
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Border innerBorder = BorderFactory.createEtchedBorder();
        Border outerBorder = BorderFactory.createTitledBorder("Requested Parts List");
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        TextFieldListener textFieldListener = new TextFieldListener(windowPartsRequest);
        buttonAdd = new JButton("Add Part");
        buttonAdd.addActionListener(textFieldListener);
        this.add(buttonAdd);

        ListenerRequest listenerRequest = new ListenerRequest();
        listenerRequest.setWindowPartsRequest(windowPartsRequest);
        buttonRequest.addActionListener(listenerRequest);
        this.add(buttonRequest);

        dynamicTextFields = new DynamicTextFields(windowPartsRequest);

        listTextField.add(dynamicTextFields);
        dynamicTextFields.addtextfieldlistener(textFieldListener);

        this.add(new JLabel("              "));
        this.add(new JLabel("p/n"));
        this.add(dynamicTextFields);
        this.add(new JLabel("    q.-ty"));
        this.add(dynamicTextFields.getQuantityTextField());
        this.setVisible(true);
        this.setVisible(true);
    }

    public int getPartsQuantity() {
        return partsQuantity;
    }

    public void setPartsQuantity(int partsQuantity) {
        this.partsQuantity = partsQuantity;
    }

    public ArrayList<RequestedPart> getPartsList() {
        ArrayList<RequestedPart> result = new ArrayList<RequestedPart>();
        Component[] components = this.getComponents();
        DynamicTextFields dynamicTextFields;
        for (Component component : components) {
            if (listTextField.contains(component)) //checks if selected component exists in ArrayList of PanelRequestParts.
            //if exists, its means that this component is of Class Dynamic Text field.
            // Remember that each time when we created  a new Dyn.T.F., and added into the Request window,
            // we also added it into Array list of PanelRequestParts.
            // So now we have access to those DynamicTextFields.
            {
                dynamicTextFields = (DynamicTextFields) component;
                RequestedPart currentPart = new RequestedPart();
                currentPart.setPartNumber(dynamicTextFields.getText());
                Integer quantity = Integer.parseInt(dynamicTextFields.getQuantityTextField().getText());
                currentPart.setQuantity(quantity);
                result.add(currentPart);
            }
        }
        System.out.println(result);
        return result;
    }

    public ArrayList<DynamicTextFields> getListTextField() {
        return listTextField;
    }

    public void setListTextField(ArrayList<DynamicTextFields> listTextField) {
        this.listTextField = listTextField;
    }
}


