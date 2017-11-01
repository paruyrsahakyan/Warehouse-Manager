package GUI.requestWindow;

import javax.swing.*;
import java.awt.*;

public class DynamicTextFields extends JTextField {
public  RequestWindow requestWindow;
public  TextFieldListener textFieldListener;

   public DynamicTextFields(RequestWindow requestWindow) {
       this.setColumns(15);
       this.requestWindow = requestWindow;
       this.addActionListener( new TextFieldListener(requestWindow));
   }
          public  void addtextfieldlistener(TextFieldListener textFieldListener){
       this.textFieldListener = textFieldListener;
          }
}
