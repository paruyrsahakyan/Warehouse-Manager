package GUI.requestWindow;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ListenerExchangeTable implements MouseListener {
    private WindowPartsRequest windowPartsRequest;
    private JTable jTable;

    public ListenerExchangeTable(WindowPartsRequest windowPartsRequest, JTable jTable) {
        this.windowPartsRequest = windowPartsRequest;
        this.jTable = jTable;

    }
    public void mouseClicked(MouseEvent e) {
        if(!windowPartsRequest.isExchangeTableEmpty()) {
            int row = jTable.rowAtPoint(e.getPoint());
            Object purtNumber = jTable.getValueAt(row, 0);
            Object canTakeString = jTable.getValueAt(row, 2);
            Object availableString = jTable.getValueAt(row, 3);
            int rowToImport = windowPartsRequest.getPanelResult().getSelectedRow();
            windowPartsRequest.getPanelResult().getTable().getModel().setValueAt(purtNumber, rowToImport, 0);
            windowPartsRequest.getPanelResult().getTable().getModel().setValueAt(canTakeString, rowToImport, 2);
            windowPartsRequest.getPanelResult().getTable().getModel().setValueAt(availableString, rowToImport, 3);
            windowPartsRequest.setVisible(true);

        }

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
