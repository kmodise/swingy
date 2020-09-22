package View;

import Model.GetHero;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
@interface validateOption
{
    int option() default 1;
}

public class MainClass {

    public  static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.err.println("Choose a game mode");
            System.exit(1);
        }
            if (args[0] == null){
                System.out.println("NO Choice");
                System.exit(1);
            }
            else if (args[0].equals("console")){
                new Console();
            }
            else if (args[0].equals("gui")){
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "1 == create hero\n2 == choose hero"));
        
        if (option == 1){
            String heroname = JOptionPane.showInputDialog(null, "heroName");
            String heroClass = JOptionPane.showInputDialog(null, "heroClass [A - C]");
            String herolevel = JOptionPane.showInputDialog(null, "heroLevel [1 - 4]");
            String heroCExperience = JOptionPane.showInputDialog(null, "heroExperience");
            String heroAttack = JOptionPane.showInputDialog(null, "heroAttack [0 - 100]");
            String heroDefence = JOptionPane.showInputDialog(null, "heroDefence [1 - 100]");
            String heroHitpoints = JOptionPane.showInputDialog(null, "heroHitpoints [1 - 100]");


            // FileWriter addHero = new FileWriter("src\\main\\java\\Model\\heroes.txt",true);
            String hero = heroname + " " + heroClass + " " + herolevel + " " + heroCExperience + " " + heroAttack + " " + heroDefence + " " + heroHitpoints + "\n";
            try {
                Files.write(Paths.get("src\\main\\java\\Model\\heroes.txt"), hero.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                System.out.println(e);
            }

            String displayHero = "\n" + "   Name ====> " + heroname + "    Class ====> " + heroClass + "   Level ===> " + herolevel + "   Experience ===> " + heroCExperience + "   Attack ===> " + heroAttack + "  Defence ===> " + heroDefence + "    Hitpoints === > " + heroHitpoints;
            try {
                Files.write(Paths.get("src\\main\\java\\Model\\heroesDisplay.txt"), displayHero.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                System.out.println(e);
            }
        }

        BufferedReader listOfHeroes = new BufferedReader(new FileReader("src\\main\\java\\Model\\heroesDisplay.txt"));
            StringBuilder printHeroes = new StringBuilder();
            String s;
            while ((s = listOfHeroes.readLine()) != null ){
                printHeroes.append(s + '\n');
            }
            JOptionPane.showMessageDialog(null, printHeroes);
        
        

//        GetHero getHero = new GetHero();
//        getHero.heroStats();
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
    else{
        System.out.println("Something went wrong");
    }
}
}
