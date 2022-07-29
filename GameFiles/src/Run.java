import ViewModel.DevConsole;

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
    public static void main(String[] args){
        DevConsole play = new DevConsole();
        play.playNewGame();
    }
}
