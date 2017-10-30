package GUI;


import javax.swing.*;
import java.awt.*;

public class MainWindow extends MainFrame{
    private MenuBarOfWindow   menuBar  = new MenuBarOfWindow();
    private ToolBar toolBar = new ToolBar();

    MainWindow(){
           this.setJMenuBar( menuBar);

           add(toolBar, BorderLayout.NORTH);
    }
}
