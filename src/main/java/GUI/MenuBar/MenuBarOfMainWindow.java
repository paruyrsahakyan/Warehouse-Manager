package GUI.MenuBar;

import GUI.MenuBar.CreatingDatabaseWindow.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarOfMainWindow extends JMenuBar {
    private JMenu file;
    private JMenuItem print;
    private JMenuItem setting;
        public MenuBarOfMainWindow(){
             file = new JMenu("File");
              print = new JMenuItem("Print");
             setting = new JMenuItem("Settings");
             setting.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent e) {
                                               WindowCreateDatabase createDatabaseWindow = new WindowCreateDatabase();
                                           }
                                       }
             );

            file.add(print);
            file.add(setting);
            this.add(file);
            JMenu create = new JMenu("Create");
            this.add(create);
            JMenu view = new JMenu("View");
            this.add(view);
            JMenu help = new JMenu("help");
            this.add(help);

    }
}
