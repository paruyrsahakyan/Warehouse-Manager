package GUI.requestWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestWindow extends JFrame {
    private JTextField partnumber;
    private JTextField textField;
    private JButton requestButton;
    private JButton closeTextButton;
    private DynamicTextPanel dynamicTextPanel;
    private DynamicTextFields dynamicTextFields;

    public RequestWindow() {
        final Container pane = this.getContentPane();

        this.setTitle("PartsRequest");
        this.setSize(new Dimension(250, 400));
        this.setResizable(false);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setLocationByPlatform(true);
        this.setVisible(true);
        pane.setLayout(new FlowLayout(FlowLayout.LEADING));

//        textField = new JTextField(10);
//        dynamicTextPanel = new DynamicTextPanel(this);
        dynamicTextFields = new DynamicTextFields(this);
        DynamicTextFieldActionListener dynamicTextFieldActionListener = new DynamicTextFieldActionListener(this, dynamicTextFields);
        dynamicTextFields.addTextDynamicTextFIeldListener(dynamicTextFieldActionListener);
        pane.add(dynamicTextFields);


//        JButton closeTextFieal;
//        textField.addActionListener( new DynamicTextFieldActionListener(this,textField));

//                System.out.println(e.getSource());
        requestButton = new JButton("Execute Request");
        closeTextButton = new JButton("x");
        closeTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pane.remove(dynamicTextFields);
                pane.remove(closeTextButton);
                pane.setVisible(true);
                //        this.add(requestButton);
                //        this.add(textField);
//            this.add(dynamicTextPanel);
            }
        });
        pane.add(closeTextButton);
        pane.setVisible(true);
    }
}
