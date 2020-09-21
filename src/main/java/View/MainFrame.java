package View;

import Controller.KeyChecker;

public class MainFrame extends javax.swing.JFrame {
    public MainFrame(){

        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setVisible(true);
        //add panel to the JFrame or it wont be visible
        this.add(panel);

        addKeyListener(new KeyChecker(panel));
    }

}