package View;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Console {
    public Console() throws IOException {
        System.out.print("-------------------------------------------------------------------------------\n");
        System.out.println("|                                                                             |");
        System.out.println("|                      WELCOME TO THE CONSOLE VERSION                         |");
        System.out.print("-------------------------------------------------------------------------------\n");
        System.out.println("1 = create hero\n2 = choose hero");
        Scanner option = new Scanner(System.in);
        int choice = Integer.parseInt(option.next());
        if (choice == 1){
            System.out.println("creating hero");
            Scanner getInputObj = new Scanner(System.in);
            System.out.println("heroName ");
            String heroName = getInputObj.next();
            System.out.println("heroClass");

            String heroClass = getInputObj.next();
            System.out.println("heroLevel");

            String heroLevel = getInputObj.next();
            System.out.println("heroExperience");

            String heroCExperience = getInputObj.next() ;
            System.out.println("heroAttack");

            String heroAttack = getInputObj.next();
            System.out.println("heroDefence");

            String heroDefence = getInputObj.next();
            System.out.println("heroHitPoints");

            String heroHitPoints = getInputObj.next();

            String hero = heroName + " " + heroClass + " " + heroLevel + " " + heroCExperience + " " + heroAttack + " " + heroDefence + " " + heroHitPoints + "\n";
            System.out.println(hero);

            try {
                Files.write(Paths.get("src\\main\\java\\Model\\heroes.txt"), hero.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                System.out.println(e);
            }

            String displayHero = "\n" + "   Name ====> " + heroName + "    Class ====> " + heroClass + "   Level ===> " + heroLevel + "   Experience ===> " + heroCExperience + "   Attack ===> " + heroAttack + "  Defence ===> " + heroDefence + "    Hitpoints === > " + heroHitPoints;
            try {
                Files.write(Paths.get("src\\main\\java\\Model\\heroesDisplay.txt"), displayHero.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                System.out.println(e);
            }


        }
        else if (choice == 2){
            System.out.println("choose hero");

            BufferedReader listOfHeroes = new BufferedReader(new FileReader("src\\main\\java\\Model\\heroesDisplay.txt"));
            String s;
            while ((s = listOfHeroes.readLine()) != null ){
                System.out.println(s);
            }

        }
        else{
            System.out.println("not a valid choice");
            System.exit(1);
        }
    }
    
}
