package GUI.MenuBar.CreatingDatabaseWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCreateDatabase extends JFrame {
    private JLabel xlsPathLabel;
    //    private JLabel dbNameLabel;
    private JTextField textFieldXlsPath;
    //    private JTextField textFieldDbName;
    private JButton buttonCreateDB;
    private JButton buttonOpen;
    private JFileChooser fileChooser;
    private JProgressBar jProgressBar;
    private JLabel labelImportStatus;


    public WindowCreateDatabase() {
        this.setTitle("Create Database");
        this.setSize(new Dimension(350, 220));
        this.setResizable(false);
//      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);

///////////// textfieds, buttons, and Label////////////////////////////////

        xlsPathLabel = new JLabel("Source path:");

        textFieldXlsPath = new JTextField(10);

        buttonOpen = new JButton("...");
        buttonOpen.setPreferredSize(new Dimension(27, 17));

        fileChooser = new JFileChooser();
        ListenerForOpenButtom listenerForOpenButtom = new ListenerForOpenButtom(buttonOpen, textFieldXlsPath);
        buttonOpen.addActionListener(listenerForOpenButtom);

        buttonCreateDB = new JButton("Create");
        ListenerForCreateButton listenerForCreateButton = new ListenerForCreateButton();
        listenerForCreateButton.setWindow(this);
        buttonCreateDB.addActionListener(listenerForCreateButton);

        jProgressBar = new JProgressBar();
        jProgressBar.setIndeterminate(true);

        labelImportStatus = new JLabel("  Choose the source file to import data !");

////////////////// Laying out pomponents ////////////////////////////////

        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(xlsPathLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(textFieldXlsPath, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 2;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(buttonOpen, gc);

        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(10, 0, 0, 0);
        add(buttonCreateDB, gc);

        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth=3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(labelImportStatus, gc);

        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth=2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(jProgressBar, gc);
        jProgressBar.setVisible(false);


        this.setVisible(true);
    }


    public void setStatusWait() {
        labelImportStatus.setText("   wait for a few minute, while data is imported");
        jProgressBar.setVisible(true);
    }

    public void setStatusComplete() {
        labelImportStatus.setText("   Data is successfully imported");
        jProgressBar.setVisible(false);

    }

    public String getTextFromTextField() {
        return textFieldXlsPath.getText();

    }
}