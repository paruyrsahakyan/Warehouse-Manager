package GUI.requestWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestWindow extends JFrame {
    private JTextField textField;
    private JButton requestButton;
    private JButton addButton;
   private DynamicTextFields dynamicTextFields;


    public RequestWindow() {
//         Container pane= this.getContentPane();
        this.setTitle("PartsRequest");
        this.setSize(new Dimension(250, 400));
        this.setResizable(false);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));

        requestButton = new JButton("Execute Request");
        this.add(requestButton);

        TextFieldListener textFieldListener = new TextFieldListener(this);

        addButton = new JButton("Add Part");

        addButton.addActionListener(textFieldListener);

        this.add(addButton);

        dynamicTextFields = new DynamicTextFields(this);
        dynamicTextFields.addtextfieldlistener(textFieldListener);
        this.add(dynamicTextFields);

        this.setVisible(true);
        this.setVisible(true);

    }
}
