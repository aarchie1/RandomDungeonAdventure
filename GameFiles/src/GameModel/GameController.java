package GameModel;

import CreatureEntityModel.CreatureEntityController;
import MapModel.MapController;

import RoomEntity.EntityController;
import RoomModel.RoomController;

import java.util.ArrayList;

/**
 * This Class will control and consolidate all the game models into the game logic
 * It ties all the models together.
 * @author Rowan W Osmon
 * @version 0.01
 */
public class GameController {


    /**
     * This controls any map actions.
     */
    private MapController myMap;
    /**
     * This controls room actions.
     */
    private RoomController myRoom;
    /**
     * This controls RoomEntitys
     */
    private CreatureEntityController myCreatures;
    /**
     * This stores the start location
     */
    private EntityController myREntity;
    private final Location theStart;

    /**
     * This stores the currentLocation
     */
    private Location myCurrentLocation;


    /**
     * The constructor creates a new GameController
     */
    public GameController(){
        myMap = new MapController();
        myRoom = new RoomController();
        myCreatures = new CreatureEntityController();
        myREntity = new EntityController();
        theStart = new Location(0,0);
        myCurrentLocation = new Location(0,0);
        myMap.setLocal(theStart);
        myCreatures.createHero("thief");


    }

    /**
     * This is used by a view to get the hero's stats.
     * This should call on the Creature Controller to get the Hero's stats
     * it should then display that as a string.
     * @return The stats of the hero as a string.
     */
    public String heroStats() {
        return myCreatures.getMyHero();
    }

    /**
     * This starts a new game
     * This method should create a new map with a starting room
     */
    public void newGame(){
        //reset the hero
        myMap = new MapController();
    }

    /**
     * This method loads a map and room state from an input string
     * It should allow for a game to be resumed with the same state as
     * the save.
     * @param save A save string created by the save game method
     */
    public void loadGame(final String save){
    //insert code here!
    }

    /**
     * This method should output a string that contains the entire map, its rooms, and their contents
     * This String is used by the load method to generate the saved map.
     * @return
     */
    public String saveGame() {
        //insert code here!
        return "";
    }

    /**
     * This method takes a string that represents up, down, left, or right.
     * Acceptable inputs are (U, D, L, R)
     * It does nothing if given an incorrect string
     * It will tell the MapController to move once in the specified direction.
     *
     * @param theDirection U,D,L,R are the only accepted inputs.
     */
    private Location inputDirection(final String theDirection){
        Location nextLoc;
        Directions d = Directions.getDirection(theDirection);
        if (d == null) {
            return myCurrentLocation;
        }
        switch (d) {
            case UP:
                nextLoc = new Location(myCurrentLocation.getMyX(), myCurrentLocation.getMyY()-1);
                break;
            case DOWN:
                nextLoc = new Location(myCurrentLocation.getMyX(), myCurrentLocation.getMyY()+1);
                break;
            case LEFT:
                nextLoc = new Location(myCurrentLocation.getMyX()-1, myCurrentLocation.getMyY());
                break;
            case RIGHT:
                nextLoc = new Location(myCurrentLocation.getMyX()+1, myCurrentLocation.getMyY());
                break;
            default:
                nextLoc = new Location(myCurrentLocation.getMyX(), myCurrentLocation.getMyY());
                break;
        }
        return nextLoc;
    }

    /**
     * This method is called on by a view to get possible actions.
     * Actions are things the player can do like drink a potion.
     * It does nothing if given an incorrect string
     * @param theAction an accepted input TBD
     * @return the Hero's Items as a string.
     */
    public String actionMenu(final String theAction) {
        String chosenAction = "";
            PlayerActions myA = PlayerActions.getAct(theAction);

            switch (myA) {
                // Consider a refactor to make UseHealthPostion take no input.
                case HEALPOT:
                    chosenAction = "Used a HealthPotion";
                    myCreatures.useHealthPotion();
                    break;
                case VISONPOT:
                    chosenAction = "Used a VisionPotion";
                    chosenAction += "\n" + myMap.getLocalMap(myCurrentLocation);
                    break;
                case PLAYERINV:
                    chosenAction = myCreatures.getMyHeroItems();
                    break;
                default:
                    chosenAction = "Not a valid Action!";
                    break;
            }
        return chosenAction;
    }
    public String actionMenu(PlayerActions theAction){
        switch (theAction) {
            case HEALPOT -> {
                myCreatures.useHealthPotion();
                return "Used a HealthPotion!";
            }
            case VISONPOT -> {
                return "Used a VisionPotion\n" + myMap.getLocalMap(myCurrentLocation);
            }
            case PLAYERINV -> {
                return myCreatures.getMyHeroItems();
            }
            default -> {
                return "Not a valid PlayerAction!";
            }
        }
    }

    /**
     * Used to input directions to the game controller.
     * This is how the player navigates between rooms.
     * methods that need to happen after a player moves go here.
     * @param theDirection
     */
    public void moveLocal(final String theDirection){
        setLocal(inputDirection(theDirection));
        // check new room for intractable
        checkForRoomEntity(myMap.getRoomAt(myCurrentLocation).getMyEntities());

    }

    /**
     * This Method is used to check a room for key objects.
     *
     *  Check if theRoomContents contains a substring that matches a Monster
     *  call to Creature control/battle if monster found
     *
     *  Check if theRoomContents contains a substring that matches an item
     *  call to Creature control/Hero if item/obj/trap found
     * @param theRoomContents
     */
    private void checkForRoomEntity(ArrayList<String> theRoomContents) {

        //check for trap

        //check for monster

        // check for item
    }


    /**
     * Used to modify the current location for moving.
     * @param theLocation
     */
    private void setLocal(final Location theLocation) {
        myCurrentLocation = theLocation;
    }

    /**
     * Returns the contents of the current room
     * @return
     */
    public String showCurrentRoom(){
        return myMap.getRoomAt(myCurrentLocation).toString();
    }

    public String showFullMap() {
        return myMap.getFullMap();}
    /**
     * This method should check for the end game condition.
     * It returns false when the condition is set, true otherwise.
     * @return
     */
    public boolean hasWon() {
        //code to check for endgame, return false if game is won
        //insert code here!
        return true;
    }

    /**
     * Used to return a combat log to the view.
     * This method should get the combat record from the
     * @return
     */
    public String combatLog() {
        String baseMsg = "There are no monsters in this room.";

        return baseMsg;
    }
}
