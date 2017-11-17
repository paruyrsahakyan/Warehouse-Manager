package GUI.MenuBar.CreatingDatabaseWindow;

import toDB.FromXLStoDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerForCreateButton implements ActionListener {
    private  JTextField textFieldXlsPath;
    private  FromXLStoDB fromXLStoDB;
    private WindowCreateDatabase window;

    ListenerForCreateButton(){

                    }

    //////////////////////////////////////////////////////////////

     public void setSourcePath(JTextField  textFieldXlsPath){
        this.textFieldXlsPath = textFieldXlsPath;
    }
/////////////////////////////////////////////////////////////////////////

    public  void setWindow(WindowCreateDatabase window){
         this.window = window;
    }

    /////////////////////////////////////////////////////////////


    public void actionPerformed(ActionEvent e) {

        window.setStatusWait();
//        jFrame.setVisible(true);
        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                String xlsPath = window.getTextFromTextField();

                fromXLStoDB = new FromXLStoDB(xlsPath);

//        fromXLStoDB.setProgressBar(jProgressBar);
                fromXLStoDB.getFromXlsSetToDB();
//        textFieldXlsPath.setEditable(false);
                window.setStatusComplete();
                            }
        });
       thread1.start();
       Thread thread2 = new Thread(new Runnable() {
           public void run() {
               try {
                   thread1.join();
               } catch (InterruptedException e1) {
                   e1.printStackTrace();
               }
               window.setStatusComplete();


           }
       });


//        jFrame.setVisible(true);
            }

}
