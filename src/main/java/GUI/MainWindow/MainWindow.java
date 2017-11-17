package GUI.MainWindow;


import GUI.MenuBar.MenuBarOfMainWindow;
import GUI.ToolBar.ToolBar;

import java.awt.*;

public class MainWindow extends MainFrame{
    private MenuBarOfMainWindow menuBar;
    private ToolBar toolBar;

    public MainWindow(){
        menuBar = new MenuBarOfMainWindow();
        toolBar = new ToolBar();
           this.setJMenuBar(menuBar);

           add(toolBar, BorderLayout.NORTH);
    }
}
