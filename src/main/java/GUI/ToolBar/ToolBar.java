package GUI.ToolBar;

import toDB.FromXLStoDB;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.requestWindow.*;

public class ToolBar extends JPanel {
    private JButton request;
    private JButton maintenance;
    private JButton d1111;
    private JButton e1111;
    private JButton h1111;

    public ToolBar() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(BorderFactory.createEtchedBorder());
    request = new JButton("Request");

    request.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            WindowPartsRequest windowPartsRequest = new WindowPartsRequest();

        }
    });


    add(request);
    maintenance = new JButton("Maintenance");
    add(maintenance);

        }

}
