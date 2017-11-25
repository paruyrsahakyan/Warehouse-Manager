package GUI.ToolBar.windowMaintenance;

import GUI.ToolBar.windowMaintenance.TM.TM;
import GUI.ToolBar.windowMaintenance.TM.TMPart;
import GUI.ToolBar.windowMaintenance.machine.Machine;
import GUI.ToolBar.windowMaintenance.machine.Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboMachine extends JComboBox implements ActionListener{
    private JComboBox comboTM;

    public ComboMachine () {
        comboTM = new JComboBox();
        Models models;

        this.setPreferredSize( new Dimension(150, 20));
        comboTM.setPreferredSize(new Dimension( 100, 20));

         models = new Models();
         this.addItem("      ");
        Object[] modelsArr = models.getMachinList().toArray();
        for(Object current: modelsArr ) {
            this.addItem(current);
        }

        this.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ComboMachine cm = (ComboMachine) e.getSource();
        JComboBox tmList = cm.getComboTM();
        tmList.removeAllItems();
        Machine machine = (Machine) cm.getSelectedItem();
        for (TM tm : machine.getTmList()) {
            tmList.addItem(tm);
        }
    }
///////////////////////// GETTERS AND SETTERS ////////////////////

    public JComboBox getComboTM() {
        return comboTM;
    }

    public void setComboTM(JComboBox comboTM) {
        this.comboTM = comboTM;
    }

}
