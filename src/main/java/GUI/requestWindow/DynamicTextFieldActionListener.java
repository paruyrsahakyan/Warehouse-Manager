package GUI.requestWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicTextFieldActionListener implements ActionListener {
    RequestWindow requestWindow;
    DynamicTextFields dynamicTextFields;
      DynamicTextFieldActionListener(RequestWindow requestWindow, DynamicTextFields dynamicTextFields){
        this.requestWindow= requestWindow;
        this.dynamicTextFields = dynamicTextFields;
//        this.jTextField = jTextField;



    }
    public void actionPerformed(ActionEvent e) {
         DynamicTextFields nextDynamicTextFields = new DynamicTextFields(requestWindow);

        requestWindow.setVisible(true);
        dynamicTextFields.setEditable(false);
        final JButton jButton = new JButton("X");


        requestWindow.add(nextDynamicTextFields);
        requestWindow.add(jButton);

        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                requestWindow.remove(dynamicTextFields);
                requestWindow.remove(jButton);
                requestWindow.setVisible(true);
            }
        });

        requestWindow.setVisible(true);
        dynamicTextFields.setEditable(false);

    }
}
