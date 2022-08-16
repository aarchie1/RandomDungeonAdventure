import ViewModel.DevConsole;

import java.util.Scanner;

/**
 * This Class picks a view and runs the program
 * @author Rowan W Osmon
 * @version 0.01
 */
public class Run {


    /**
     * This is used to run the program.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        DevConsole play = new DevConsole();
        play.playNewGame();
        boolean flag = true;
        while (flag) {
            System.out.println("Would you like to start a new game? Enter Y or N:");
            Scanner in = new Scanner(System.in);
            String response = in.next();
            while (!response.equalsIgnoreCase("Y") || !response.equalsIgnoreCase("N")) {
                if (response.equalsIgnoreCase("N")) {
                    flag = false;
                    break;
                } else if (response.equalsIgnoreCase("Y")) {
                    flag = true;
                    play = new DevConsole();
                    play.playNewGame();
                } else {
                    System.out.println("Not a valid input. Please Enter Y or N");
                    response = in.next();
                }
                System.out.println("Would you like to start a new game? Enter Y or N:");
                response = in.next();
            }
        }
    }
}
