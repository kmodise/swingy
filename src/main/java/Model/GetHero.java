package Model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetHero {
    BufferedReader heroObj;

    public String Heroname = getHeroName(heroStats());
   public char  Heroclass = getHeroClass(heroStats());
  public   int     Level = getLevel(heroStats());
   public int     Experience = getExperience(heroStats());
   public int     Attack = getAttack(heroStats());
   public int     Defense = getDefence(heroStats());
   public int     HitPoints = getHitPoints(heroStats());


    public static String getHeroName(String heroStats){
        String[] heroName = heroStats.split(" ");
        return heroName[0];
    }
    public static char getHeroClass(String heroStats){
        String[] Class = heroStats.split(" ");
        return Class[1].charAt(0);
    }

    public static  int getLevel(String heroStats){
        String[] Level = heroStats.split(" ");
        return Integer.parseInt(Level[2]);
    }

    public static  int getExperience(String heroStats){
        String[] Experiments = heroStats.split(" ");
        return Integer.parseInt(Experiments[3]);
    }

    public static  int getAttack(String heroStats){
        String[] Attack = heroStats.split(" ");
        return Integer.parseInt(Attack[4]);
    }

    public static  int getDefence(String heroStats){
        String[] Defence = heroStats.split(" ");
        return Integer.parseInt(Defence[5]);
    }

    public  static int getHitPoints(String heroStats){
        String[] HitPl = heroStats.split(" ");
        return Integer.parseInt(HitPl[6]);
    }


    public String heroStats()  {

        ArrayList<String> heroes = new ArrayList<>();

        try(BufferedReader buffObj = new BufferedReader(new FileReader("src\\main\\java\\Model\\heroes.txt"))){
            String s;
            while((s = buffObj.readLine() )!= null){
                heroes.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        JOptionPane.showMessageDialog(null,heroes);
        int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose a hero"));
        System.out.println(heroes.get(i));
        return heroes.get(i);
    }
}