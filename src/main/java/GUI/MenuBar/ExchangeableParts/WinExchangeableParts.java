package GUI.MenuBar.ExchangeableParts;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinExchangeableParts extends JFrame implements ActionListener {
    JTextField partNumber;
    JButton buttonAdd;
    JButton buttonSave;

    public WinExchangeableParts() {
        buttonAdd = new JButton("Add Part");
        buttonSave = new JButton("Save");

        this.setLayout(new FlowLayout());
        this.setSize(120,320);
        this.setResizable(false);
        this.setLocationByPlatform(true);
        this.add(buttonAdd);
        this.add(buttonSave);
        this.add(new JTextField(16));
        this.add(new JTextField(16));

        buttonAdd.addActionListener(this);

        ListenerButtonSave listenerButtonSave = new ListenerButtonSave(this);
        buttonSave.addActionListener(listenerButtonSave);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.add(new JTextField(16) );
        this.setVisible(true);
    }

    }


