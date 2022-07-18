package GameModel;

import CreatureEntityModel.CreatureEntityController;
import MapModel.MapController;
import RoomModel.RoomController;

/**
 * This Class will control and consolidate all the game models into the game logic
 * It ties all the models together.
 */
public class GameController {

    /**
     * This controls map actions.
     */
    private MapController myMap = new MapController() ;
    /**
     * This controls room actions.
     */
    private RoomController myRoom;
    /**
     * This controls RoomEntitys
     */
    private CreatureEntityController myCreatures;

    private final Location theStart;
    private Location myCurrentLocation;

    /**
     * The constructor creates a new GameControler
     */
    GameController(){
        theStart = new Location(0,0);
        myCurrentLocation = new Location(0,0);
        myMap.setLocal(theStart);


    }

    /**
     * This starts a new game
     *
     * This method should create a new map with a starting room
     */
    public void newGame(){
        myMap = new MapController();
    }

    /**
     * This method loads a map and room state from an input string
     * It should allow for a game to be resumed with the same state as
     * the save.
     * @param save A save string created by the save game method
     */
    public void loadGame(final String save){

    }

    /**
     * This method should output a string that contains the entire map, its rooms, and their contents
     * This String is used by the load method to generate the saved map.
     * @return
     */
    public String saveGame() {
        return "";
    }

    /**
     * This method takes a string that represents up, down, left, or right.
     * It does nothing if given an incorrect string
     * It will tell the MapController to move once in the specified direction.
     *
     * @param theDirection UP,DOWN,LEFT,RIGHT are the only accepted inputs.
     */
    public void enterDirection(final String theDirection){

    }

    /**
     * This method is called on by a view to do an action.
     * Actions are things the player can do like drink a potion.
     * It does nothing if given an incorrect string
     * @param theAction an accepted input TBD
     */
    public void actionMenu(final String theAction){

    }

    /**
     * Used to input directions to the game controller.
     * @param theDirection
     */
    public void moveLocal(String theDirection){
        int theX = theStart.getMyX();
        int theY = theStart.getMyY();
        switch(theDirection) {
            case "up":      theY++;
                break;
            case "down":    theY--;
                break;
            case "left":    theX--;
                break;
            case "right":   theX++;
                break;
            default:        throw new RuntimeException("Not a valid input!");
        }
        setLocal(new Location(theX, theY));

    }

    /**
     * Used to modify the current location for moving.
     * @param theLocation
     */
    public void setLocal(final Location theLocation) {
        myCurrentLocation = theLocation;
    }

    /**
     * Returns the contents of the current room
     * @return
     */
    public String showCurrentRoom(){
        return myMap.getRoomAt(myCurrentLocation).toString();
    }

    public String toString(){
        return "This is the GameControl";
    }
}
