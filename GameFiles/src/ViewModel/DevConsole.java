package ViewModel;

import GameModel.GameController;

import java.util.Scanner;

/**
 * This class is used for player interaction with the game model.
 * It uses the console for input/output.
 */
public class DevConsole {
    GameController myGame = new GameController();
    Scanner s = new Scanner(System.in);

    DevConsole(){
        System.out.println("Welcome to RADS!");
        System.out.println(myGame.showCurrentRoom());

    }

    public void playNewGame(){
        myGame.newGame();
        gameLogicLoop();
    }
    private void gameLogicLoop() {

        while (myGame.hasWon()){
            // display stuff
         System.out.println(myGame.showCurrentRoom());
         System.out.println("Please input W, A, S, or D");
            // take player inputs
         String in = s.nextLine();
         myGame.moveLocal(in);
            // return new state in loop

        }
        // end game stuff
    }
}
