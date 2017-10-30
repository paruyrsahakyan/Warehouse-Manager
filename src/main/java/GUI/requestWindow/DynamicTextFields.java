package GUI.requestWindow;

        import javax.swing.*;
        import java.awt.*;

public class DynamicTextFields extends JTextField {
    RequestWindow requestWindow;
    DynamicTextFieldActionListener dynamicTextFieldActionListener;
    DynamicTextFields( RequestWindow requestWindow) {
        this.requestWindow = requestWindow;
        this.setColumns(15);
                addActionListener(new DynamicTextFieldActionListener(requestWindow, this));

    }
    public void addTextDynamicTextFIeldListener(DynamicTextFieldActionListener dynamicTextFieldActionListener){
        this.dynamicTextFieldActionListener = dynamicTextFieldActionListener;

    }
}
