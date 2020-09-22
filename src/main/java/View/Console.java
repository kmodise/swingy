package View;

import java.util.Scanner;

public class Console {
    public Console(){
        System.out.print("-------------------------------------------------------------------------------\n");
        System.out.println("|                                                                             |");
        System.out.println("|                      WELCOME TO THE CONSOLE VERSION                         |");
        System.out.print("-------------------------------------------------------------------------------\n");
        System.out.println("1 = create hero\n2 = choose hero");
        Scanner option = new Scanner(System.in);
        int choice = Integer.parseInt(option.next());
        System.out.println(choice);
    }
    
}
