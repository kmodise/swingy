package View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        }
    }
    
}
