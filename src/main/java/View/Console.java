package View;

import javax.swing.*;
import Model.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
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

        if (choice != 2 && choice != 1){
            System.out.println("invalid choice");
            System.exit(1);
        }

        if (choice == 1){
            System.out.println("creating hero");
            Scanner getInputObj = new Scanner(System.in);
            System.out.println("heroName ");
            String heroName = getInputObj.next();
            System.out.println("heroClass[A - D]");

            String heroClass = getInputObj.next();
            System.out.println("heroLevel[1 - 4]");

            String heroLevel = getInputObj.next();
            System.out.println("heroExperience");

            String heroCExperience = getInputObj.next() ;
            System.out.println("heroAttack[1 - 100]");

            String heroAttack = getInputObj.next();
            System.out.println("heroDefence[1 - 100]");

            String heroDefence = getInputObj.next();
            System.out.println("heroHitPoints[1 - 100]");

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
            System.out.println("choose hero");

            BufferedReader listOfHeroes = new BufferedReader(new FileReader("src\\main\\java\\Model\\heroesDisplay.txt"));
            String s;
            while ((s = listOfHeroes.readLine()) != null ){
                System.out.println(s);
            }

            System.out.println("type in the number of the hero you want");
            Scanner pickHeroObj = new Scanner(System.in);
            int pickHero = Integer.parseInt(pickHeroObj.next());
        ArrayList<String> heroes = new ArrayList<>();

        try(BufferedReader buffObj = new BufferedReader(new FileReader("src\\main\\java\\Model\\heroes.txt"))){
            String j;
            while((j = buffObj.readLine() )!= null){
                heroes.add(j);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String HeroName = GetHero.getHeroName(heroes.get(pickHero));
        char  HeroClass = GetHero.getHeroClass(heroes.get(pickHero));
        int     Level = GetHero.getLevel(heroes.get(pickHero));
        int     Experience = GetHero.getExperience(heroes.get(pickHero));
        int     Attack = GetHero.getAttack(heroes.get(pickHero));
        int     Defense = GetHero.getDefence(heroes.get(pickHero));
        int     HitPoints = GetHero.getHitPoints(heroes.get(pickHero));
        System.out.println( "you have picked    --->   " + HeroName);

        int movement = 0;
        int wall = 10;
        int isThereAnEnemy;
        int step = 1;
        Random randomObj = new Random();
        while (movement < wall){
            isThereAnEnemy = randomObj.nextInt(2);
            System.out.println(isThereAnEnemy);
            if (isEnemy() == 1){
                System.out.println("you have Encountered and enemy\n1 == FIGHT\n2 == RUN");
                Scanner sObj = new Scanner(System.in);
                int runOrFight = sObj.nextInt();
                if (runOrFight == 1){
                    if (Attack < enemy()){
                        System.out.println("YOU LOSE, ENEMY TOO STRONG");
                        System.exit(1);
                    }
                    else {
                        System.out.println("ENEMY DEFEATED");
                    }
                }
                else if (runOrFight == 2){
                    System.out.println("YOU RAN, AND TOOK A STEP BACKWARD");
                    movement--;
                    step = 0;
                }
            }
            if (step != 0){
                System.out.println(" YOU TOOK A STEP FORWARD");
            }

            movement++;
        }
        System.out.println("YOU WIN!!!");

    }

    public  int isEnemy(){
        Random randomObj = new Random();
        return randomObj.nextInt(2);
    }

    public int  enemy(){
        Random randomObj = new Random();

        int defence = randomObj.nextInt(100) + 1;
        return  defence;
    }
    
}
