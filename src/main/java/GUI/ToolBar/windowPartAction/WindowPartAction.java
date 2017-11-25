package GUI.ToolBar.windowPartAction;

import javax.swing.*;
import java.awt.*;

public class WindowPartAction extends JFrame {
    JRadioButton radioIn;
    JRadioButton radioOut;

    public WindowPartAction() {
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setLayout(new GridBagLayout());

        radioIn = new JRadioButton("In");
        this.add(radioIn);

        radioOut = new JRadioButton("OUT");
        this.add(radioOut);

        GridBagConstraints gc = new GridBagConstraints();


        gc.gridx=1;
        gc.gridy =0;
        this.add(radioIn, gc);

        gc.gridx =3;
        gc.gridy =0;
        this.add(radioOut, gc);







    }

}
