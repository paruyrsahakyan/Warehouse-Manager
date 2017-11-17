package GUI.requestWindow;

import javax.swing.*;
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

        this.setPreferredSize(new Dimension(250, 400));
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));


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
        this.add(dynamicTextFields);

        this.setVisible(true);
        this.setVisible(true);
    }

    public int getPartsQuantity() {
        return partsQuantity;
    }

    public void setPartsQuantity(int partsQuantity) {
        this.partsQuantity = partsQuantity;
    }

    public ArrayList<String> getPartsList() {
        ArrayList<String> result = new ArrayList<String>();
        Component[] components = this.getComponents();
        DynamicTextFields dynamicTextFields;
        for (Component component : components) {
            if (!component.equals(this.buttonRequest) && !component.equals(this.buttonAdd)) {

                dynamicTextFields = (DynamicTextFields) component;
                result.add(dynamicTextFields.getText());
            }
        }
        System.out.println(result);
        return result;
    }
}


