package GUI.requestWindow;

import javax.swing.*;
import java.awt.*;

public class DynamicTextFields extends JTextField {
public  WindowPartsRequest windowPartsRequest;
public  TextFieldListener textFieldListener;

   public DynamicTextFields(WindowPartsRequest windowPartsRequest) {
       this.setColumns(15);
       this.windowPartsRequest = windowPartsRequest;
       this.addActionListener( new TextFieldListener(windowPartsRequest));
   }
          public  void addtextfieldlistener(TextFieldListener textFieldListener){
       this.textFieldListener = textFieldListener;
          }
}
