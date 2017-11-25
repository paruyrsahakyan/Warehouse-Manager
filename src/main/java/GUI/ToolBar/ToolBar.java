package GUI.ToolBar;

import GUI.ToolBar.windowMaintenance.WindowMaintenance;
import GUI.ToolBar.windowPartAction.WindowPartAction;
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
    private JButton partAction;
    private JButton h1111;

    public ToolBar() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(BorderFactory.createEtchedBorder());

    //adding request button
    request = new JButton("Request");
    this.add(request);
        request.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new WindowPartsRequest();
        }
    });

     // adding maintenance button
    maintenance = new JButton("Maintenance");
    maintenance.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new WindowMaintenance();
        }
    });
    add(maintenance);


    // adding partAction button
        partAction = new JButton("Part Action");
        this.add(partAction);
          partAction.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  new WindowPartAction();
              //adding parts for maintenance

              }
          });


        }

}
