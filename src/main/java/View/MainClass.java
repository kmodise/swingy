package View;

import Model.GetHero;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

public class MainClass {
    public  static void main(String[] args){
        GetHero getHero = new GetHero();
        getHero.heroStats();
        MainFrame frame = new MainFrame();

        frame.setSize(700, 700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setting the location of our window to  be in the middle
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2 ), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
        //make the window no resizable
       frame.setResizable(false);
        frame.setTitle("game mode");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        
    }
}
