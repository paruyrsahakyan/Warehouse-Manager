package GUI.ToolBar.windowMaintenance;

import GUI.ToolBar.windowMaintenance.TM.TM;
import GUI.ToolBar.windowMaintenance.TM.TMPart;
import GUI.ToolBar.windowMaintenance.machine.Machine;
import GUI.requestWindow.RequestedPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListenerFindPart implements ActionListener {
    WindowMaintenance windowMaintenance;
    PanelMachines panelMachines;

    ListenerFindPart(WindowMaintenance windowMaintenance, PanelMachines panelMachines) {
        this.windowMaintenance = windowMaintenance;
        this.panelMachines = panelMachines;

    }

    public void actionPerformed(ActionEvent e) {
        Component[] components = panelMachines.getComponents();
        JTextArea jTextArea = windowMaintenance.getPanelReqParts().getjTextArea();
        jTextArea.setText("");

        windowMaintenance.getPanelResult().initTable();

        for (Component component : components) {
            if (component.getClass().getName().endsWith("ComboMachine")) {
                ComboMachine comboMachine = (ComboMachine) component;
                Machine machine = (Machine) comboMachine.getSelectedItem();
                String model = machine.getModel() + "\n\n";

                jTextArea.append(model);
                TM tm = (TM) comboMachine.getComboTM().getSelectedItem();
                ArrayList<RequestedPart> partList = new ArrayList<RequestedPart>();
                this.windowMaintenance.getPanelResult().setNewMachineName(machine.getModel());
                for (TMPart tmPart : tm.getPartList()) {
                    jTextArea.append(tmPart.getPartNumber() + "::::::: " + tmPart.getQuantity() + "\n");
                    RequestedPart currentPart = new RequestedPart(tmPart.getPartNumber(), tmPart.getQuantity());
                    partList.add(currentPart);
                }
                jTextArea.append("\n\n");

                this.windowMaintenance.getPanelResult().showResult(partList);

            }
        }

    }
}

