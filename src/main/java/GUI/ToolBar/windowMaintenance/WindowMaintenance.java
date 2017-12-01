package GUI.ToolBar.windowMaintenance;

import GUI.MainWindow.MainFrame;

import javax.swing.*;
import java.awt.*;

public class WindowMaintenance extends JFrame{
    private PanelMachines panelMachines;
    private PanelResult panelResult;
    private PanelReqParts panelReqParts;

    public WindowMaintenance() {
        panelMachines = new PanelMachines(this);
        panelResult = new PanelResult(this);
        panelReqParts = new PanelReqParts(this);

        this.setSize(new Dimension(1000, 400));
        this.setLocationByPlatform(true);
        this.setLayout(new BorderLayout());

        this.add(panelMachines, BorderLayout.WEST);

        this.add(panelResult, BorderLayout.EAST);
        this.add(panelReqParts, BorderLayout.CENTER);



        this.setVisible(true);

    }
/////////////////////////////////////////////GETTERS AND SETTERS ///////////////////////

    public PanelMachines getPanelMachines() {
        return panelMachines;
    }

    public PanelResult getPanelResult() {
        return panelResult;
    }

    public PanelReqParts getPanelReqParts() {
        return panelReqParts;
    }
}
