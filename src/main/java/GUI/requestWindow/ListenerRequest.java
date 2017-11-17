package GUI.requestWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ListenerRequest implements ActionListener  {
    private WindowPartsRequest windowPartsRequest;

    public void setWindowPartsRequest(WindowPartsRequest windowPartsRequest) {
        this.windowPartsRequest = windowPartsRequest;
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList<String>  requestedParts = windowPartsRequest.getRequestedParts();
        windowPartsRequest.showRequestResult(requestedParts);
        }
       }

