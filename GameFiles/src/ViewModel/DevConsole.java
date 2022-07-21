package ViewModel;

import GameModel.GameController;

import java.util.Scanner;

/**
 * This class is used for player interaction with the game model.
 * It uses the console for input/output.
 */
public class DevConsole {
    GameController myGame = new GameController();
    Scanner S = new Scanner(System.in);

    DevConsole(){
        System.out.println("Welcome to RADS!");
        System.out.println(myGame.showCurrentRoom());

    }

    public void playNewGame(){
        myGame.newGame();

    }
    private void gameLogicLoop() {
        while (myGame.hasWon()){

        }
    }
}
