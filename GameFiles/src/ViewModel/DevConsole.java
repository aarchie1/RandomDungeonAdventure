package ViewModel;

import GameModel.GameController;
import GameModel.PlayerActions;

import java.util.Scanner;

/**
 * This class is used for player interaction with the game model.
 * It uses a Scanner to parse player input
 * It uses the console for input/output.
 */
public class DevConsole {
    /**
     * Our game model is interacted with in this game controller.
     */
    GameController myGame;
    Scanner s;

    public DevConsole() {
        s = new Scanner(System.in);
        System.out.println("Welcome to RADS!");
        myGame = new GameController();
        //Character selection choice prompt here
        String myHero = charSelect();
        System.out.println("Selected " + myHero);
        System.out.println("The " + myHero + " has entered a Dungeon in search of " +
                "4 legendary artifacts!");
        //System.out.println(myGame.showCurrentRoom());

    }

    private String charSelect() {
        return "charSelect placeholder";
    }

    public void playNewGame() {
        myGame.newGame();
        gameLogicLoop();

    }

    private void gameLogicLoop() {
        // at start of each loop, check for win condition
        while (!myGame.hasWon()) {
            // display stuff
            System.out.println(myGame.showCurrentRoom());
            takeAction(promptAction());
            if (myGame.hasLost()) {
                System.out.println("Hero has has lost! GAME OVER!");
                break;
            }
        }
        if(myGame.hasWon()){
            System.out.println("Hero has WON! CONGRATS!");
        }

        //System.out.println(myGame.showFullMap()); Not Currently Working
        // end game stuff
    }

    private void promptToMove() {
        System.out.println("Please input w, a, s, or d");
        // take player inputs
        String in = s.nextLine();
        myGame.moveLocal(in);
    }


    private int promptAction(){
        boolean goodChoice = true;
        String inputs = "";
        int choice = 0;
        while (goodChoice) {
            System.out.println("Please input the action you wish to do.\n" +
                    "Your options are:\n" +
                    "1 - Move to another room.\n" +
                    "2 - Get your status.\n" +
                    "3 - Drink a HealthPotion.\n" +
                    "4 - Drink a VisionPotion.\n");
            // take player inputs
            inputs = s.nextLine();
            try {
                choice = Integer.parseInt(inputs);
            } catch (Exception e) {
                System.out.println("Input was: " + inputs);
                choice = 0;
            }


           if (choice == 1 || choice == 2 ||
            choice == 3 || choice == 4 || choice == 5){
               goodChoice = false;
           }
        }
        return choice;
    }

    private void takeAction(int theChoice){

        switch (theChoice) {
            case 1 -> {
                System.out.println("Move Selected!");
                promptToMove();
                break;
            }
            case 2 -> {
                System.out.println("Status selected!\n" + myGame.actionMenu(PlayerActions.PLAYERINV));
                break;
            }
            case 3 -> {
                System.out.println("HealthPotion selected!\n" + myGame.actionMenu(PlayerActions.HEALPOT));
                break;
            }
            case 4 -> {
                System.out.println("VisionPotion selected!\n" + myGame.actionMenu(PlayerActions.VISONPOT));
                break;
            }
            case 5 -> {
                System.out.println("GODMODE SELECTED!\n" + myGame.actionMenu(PlayerActions.GODMODE));
                break;
            }
            default -> {
                System.out.println("Not a valid choice!");
                promptAction();
                break;
            }
        }
    }
}
