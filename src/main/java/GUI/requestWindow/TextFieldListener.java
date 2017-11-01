package GUI.requestWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListener  implements ActionListener{
    private RequestWindow requestWindow;
//    private DynamicTextFields dynamicTextFields;

    TextFieldListener(RequestWindow requestWindow)
        {
    this.requestWindow = requestWindow;
//    this.dynamicTextFields = dynamicTextFields;
    }
    public void actionPerformed(ActionEvent e) {
        requestWindow.add(new DynamicTextFields(requestWindow));
        requestWindow.setVisible(true);
    }
}
