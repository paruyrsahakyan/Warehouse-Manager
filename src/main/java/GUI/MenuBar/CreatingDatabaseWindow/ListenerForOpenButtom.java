package GUI.MenuBar.CreatingDatabaseWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ListenerForOpenButtom  implements ActionListener {
    private JButton openButton;
    private WindowCreateDatabase windowCreateDatabase;
    private JTextField textFieldXlsPaths;


    ListenerForOpenButtom(JButton openButton, JTextField textFieldXlsPaths) {
        this.openButton = openButton;
        this.windowCreateDatabase = windowCreateDatabase;
        this.textFieldXlsPaths = textFieldXlsPaths;

    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser("E:\\Paruyr\\codes\\warehouse\\src\\main\\resources.");
//        File file  = new File("E:\\Paruyr\\codes\\warehouse\\src\\main\\resources");

        if (e.getSource() == openButton) {
            if (fileChooser.showOpenDialog(openButton) == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                textFieldXlsPaths.setText(filePath);
//                textFieldXlsPaths.setEditable(false);
            }

        }
    }
}
