package GUI.ToolBar.windowMaintenance;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMachines extends JPanel implements ActionListener {
    private JButton buttonNew;
    private JButton buttonRequest;
    private ComboMachine comboMachine;
    private WindowMaintenance windowMaintenance;
    private  GridBagConstraints gc;

    PanelMachines(WindowMaintenance windowMaintenance) {
        this.windowMaintenance = windowMaintenance;
        this.comboMachine = new ComboMachine();
        this.gc = new GridBagConstraints();

        this.setPreferredSize(new Dimension(200, 400));
        Border innerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
        Border outerBorder = BorderFactory.createTitledBorder("Maintenance To Do");
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.setLayout(new GridBagLayout());
        buttonNew = new JButton("NEW");
        buttonNew.addActionListener(this);
        buttonRequest = new JButton("FIND PARTS");

        ListenerFindPart listenerFindPart = new ListenerFindPart(windowMaintenance, this);
        buttonRequest.addActionListener(listenerFindPart);


        /////////////////////////// LAYING OUT /////////////////////////////////

        gc.gridy = 0;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
//        gc.insets = new Insets(0, 0, 30, 0);
        this.add(buttonNew, gc);

        gc.gridy = 0;
        gc.gridx = 1;
        this.add(buttonRequest, gc);

//        gc.insets = new Insets(0, 0, 0, 0);

        gc.gridy = 1;
        gc.gridx = 0;
        gc.weighty = 1;
//        gc.anchor = GridBagConstraints.NORTH;
        gc.fill = GridBagConstraints.NONE;
        this.add(comboMachine, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        this.add(comboMachine.getComboTM(), gc);

    }

    public void actionPerformed(ActionEvent e) {
        ComboMachine comboMachine = new ComboMachine();

        gc.gridy++;
        gc.gridx = 0;
        this.add(comboMachine, gc);

        gc.gridx = 1;
        this.add( comboMachine.getComboTM(), gc);


        windowMaintenance.setVisible(true);


}
}
