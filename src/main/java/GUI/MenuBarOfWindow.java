package GUI;

import javax.swing.*;
import java.awt.*;

public class MenuBarOfWindow extends JMenuBar {

        MenuBarOfWindow(){
            JMenu file = new JMenu("File");
             JMenuItem print = new JMenuItem("Print");
            JMenuItem setting = new JMenuItem("Setting");

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
