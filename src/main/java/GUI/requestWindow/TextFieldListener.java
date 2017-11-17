package GUI.requestWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListener  implements ActionListener{
    private WindowPartsRequest windowPartsRequest;

//    private DynamicTextFields dynamicTextFields;

    TextFieldListener(WindowPartsRequest windowPartsRequest)
        {

    this.windowPartsRequest = windowPartsRequest;
//    this.dynamicTextFields = dynamicTextFields;
    }
    public void actionPerformed(ActionEvent e) {
        windowPartsRequest.addTextField();
        windowPartsRequest.setVisible(true);
    }
}
