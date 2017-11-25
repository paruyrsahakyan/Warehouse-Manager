package GUI.ToolBar.windowMaintenance;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelReqParts extends JPanel {

    private WindowMaintenance windowMaintenance;
    private  JTextArea jTextArea;

    public PanelReqParts(WindowMaintenance windowMaintenance) {
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
                this.windowMaintenance = windowMaintenance;

        this.setPreferredSize( new Dimension(400, 400));

//        this.setMaximumSize(new Dimension(300, 100));
        Border innerBorder = BorderFactory.createEmptyBorder(3,3,3,3);
        Border outerBorder = BorderFactory.createTitledBorder("Mainenance Parts");
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.setLayout( new BorderLayout());
        this.add(jTextArea, BorderLayout.CENTER);
        jTextArea.setBorder(BorderFactory.createEtchedBorder());

    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }
}
