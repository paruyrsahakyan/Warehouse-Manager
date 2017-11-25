package GUI.ToolBar.windowMaintenance;

import GUI.MainWindow.MainFrame;

import java.awt.*;

public class WindowMaintenance extends MainFrame {
    private PanelMachines panelMachines;
    private PanelResult panelResult;
    private PanelReqParts panelReqParts;

    public WindowMaintenance() {
        panelMachines = new PanelMachines(this);
        panelResult = new PanelResult(this);
        panelReqParts = new PanelReqParts(this);


        this.setLayout(new BorderLayout());

        this.add(panelMachines, BorderLayout.WEST);

        this.add(panelResult, BorderLayout.EAST);
        this.add(panelReqParts, BorderLayout.CENTER);
        this.setSize(new Dimension(1000, 400));


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
