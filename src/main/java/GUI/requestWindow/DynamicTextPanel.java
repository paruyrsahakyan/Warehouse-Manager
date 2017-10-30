package GUI.requestWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicTextPanel extends JPanel{
    private DynamicTextFields dynamicTextFields;
    private JButton jButton;
    RequestWindow requestWindow1;

    DynamicTextPanel (RequestWindow requestWindow2) {
        this.requestWindow1 = requestWindow2;
//        this.setSize(15,5);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        dynamicTextFields = new DynamicTextFields(requestWindow1);

                jButton = new JButton("X");
                jButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
//                        jButton.setVisible(false);
                        dynamicTextFields.setVisible(false);
                        add(dynamicTextFields);
                        add(jButton);
                        requestWindow1.setVisible(true);
                    }
                });
                       }
                       public void addTextPanelListener() {

                       }

}
