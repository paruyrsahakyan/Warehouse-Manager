package GUI.MenuBar;

import GUI.MenuBar.CreatingDatabaseWindow.*;
import GUI.MenuBar.ExchangeableParts.WinExchangeableParts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class        MenuBarOfMainWindow extends JMenuBar {
    private JMenu file;
    private JMenuItem print;
    private JMenuItem DBsetting;
    private  JMenuItem exchangeableParts;
        public MenuBarOfMainWindow(){
             file = new JMenu("File");
              print = new JMenuItem("Print");
             DBsetting = new JMenuItem("Database Settings");
             exchangeableParts = new JMenuItem("Exchangeable Parts");

             DBsetting.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent e) {
                WindowCreateDatabase createDatabaseWindow = new WindowCreateDatabase();
                                           }
                                       }
             );

             exchangeableParts.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     new WinExchangeableParts();
                 }
             });

            file.add(print);
            file.add(DBsetting);
            file.add(exchangeableParts);
            this.add(file);
            JMenu create = new JMenu("Create");
            this.add(create);
            JMenu view = new JMenu("View");
            this.add(view);
            JMenu help = new JMenu("help");
            this.add(help);

    }
}
