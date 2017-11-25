package GUI.requestWindow;

import javax.swing.*;
import java.awt.*;

public class DynamicTextFields extends JTextField {
public  WindowPartsRequest windowPartsRequest;
public  TextFieldListener textFieldListener;
public JTextField quantityTextField;
public double quantity;

   public DynamicTextFields(WindowPartsRequest windowPartsRequest) {
       this.setColumns(15);
       quantityTextField = new JTextField(5);
       quantityTextField.setText("0");
       quantityTextField.addActionListener(new TextFieldListener(windowPartsRequest));
       this.windowPartsRequest = windowPartsRequest;
       this.addActionListener( new TextFieldListener(windowPartsRequest));
   }
          public  void addtextfieldlistener(TextFieldListener textFieldListener){
       this.textFieldListener = textFieldListener;
          }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }
}
