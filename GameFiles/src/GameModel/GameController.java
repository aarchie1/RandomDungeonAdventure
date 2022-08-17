package GameModel;

import CreatureEntityModel.CreatureEntityController;
import MapModel.MapController;

import RoomEntity.DoorFactory;
import RoomEntity.EntityController;
import RoomModel.RoomController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This Class will control and consolidate all the game models into the game logic
 * It ties all the models together.
 * @author Rowan W Osmon
 * @version 0.01
 */
public class GameController {


    private static final int TRAP_DAMAGE = 15;
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

    private boolean noClip;


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
        noClip = false;
        myMap.exploredUpdate(theStart);
        myCreatures.createHero("thief");
    }

    /**
     * This is used by a view to get the hero's stats.
     * This should call on the Creature Controller to get the Hero's stats
     * it should then display that as a string.
     * @return The stats of the hero as a string.
     */
    public String heroStats() {
        return myCreatures.getMyHeroStats();
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
                case HEALPOT:
                    if(canUseHealthPotion()){
                        chosenAction = "Used a HealthPotion";
                        myCreatures.useHealthPotion();
                    } else {
                        chosenAction = "No potions available";
                    }
                    break;
                case VISONPOT:
                    if(canUseVisionPotion()){
                        chosenAction = "Used a VisionPotion";
                        myCreatures.useHealthPotion();
                    } else {
                        chosenAction = "No potions available";
                    }

                    chosenAction += "\n" + myMap.getLocalMap(myCurrentLocation);
                    break;
                case PLAYERINV:
                    chosenAction = myCreatures.getMyHeroStats();
                    break;
                case GODMODE:
                    chosenAction = "GODMODE ENABLED";
                    break;
                default:
                    chosenAction = "Not a valid Action!";
                    break;
            }
        return chosenAction;
    }

    private boolean canUseVisionPotion() {
        if(myCreatures.getMyHeroVisionPotions() > 0){
            return true;
        }
        return false;
    }

    private boolean canUseHealthPotion() {
        if(myCreatures.getMyHeroHealthPotions() > 0){
            return true;
        }
        return false;
    }

    public String actionMenu(PlayerActions theAction){
        switch (theAction) {
            case HEALPOT -> {
                if(canUseHealthPotion()){
                    myCreatures.useHealthPotion();
                    return "Used a HealthPotion!";
                }
                return "No potions available";
            }
            case VISONPOT -> {
                if(canUseVisionPotion()){
                    myCreatures.useVisionPotion();
                    return "Used a VisionPotion\n" + myMap.getLocalMap(myCurrentLocation);
                }
                return "No potions available";
            }
            case PLAYERINV -> {
                return myCreatures.getMyHeroStats();
            }
            case GODMODE -> {
                myCreatures.setGodMode();
                noClip = true;
                return "DEVCOMMAND ACTIVATED... GODMODE";
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
    public String moveLocal(final Directions theDirection){
        //check for a valid move
        if (!checkForDoor(theDirection)) {
            return "A Wall bars your path!";
        }
        String out = "";
        //update the location
        Location next = Directions.nextLocation(theDirection,myCurrentLocation);
        setLocal(next);
        // check for interactable
        if(checkInteractables(myMap.getRoomAt(myCurrentLocation).getMyEntities())){
            // This should be replaced with a call to return a string instead on v0.03
            out = showCurrentRoom();
        }
        // check new room for intractable
            checkForRoomEntity(myMap.getRoomAt(myCurrentLocation).getMyEntities());
        return out;
    }



    private boolean checkForDoor(Directions theNext) {
            if (noClip) {
                return noClip;
            }
        return showCurrentRoom().contains(DoorFactory.getDoor(theNext.toString()).toString());
    }

    private boolean checkInteractables(ArrayList<String> theRoomContents){
        boolean flag = false;
        //check for trap
        int stop = theRoomContents.size();
        for(String s: theRoomContents){
            if (myREntity.isTrap(s)){
                flag = true;
            }
            //check for monster
            else if (myREntity.isMonster(s)){
                flag = true;
            }
            // check for item
            else if (myREntity.isItem(s)){
                flag = true;
            }
        }
        return flag;
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
        int stop = theRoomContents.size();
        for(int i = 0; i< stop; i++){
            String s = theRoomContents.get(i);
            if (myREntity.isTrap(s)){
                myCreatures.setHeroDamage(TRAP_DAMAGE);
            }
        //check for monster
            else if (myREntity.isMonster(s)){
                myCreatures.fightAMonster(s);
                myMap.removeEntity(myCurrentLocation,s);
                System.out.println(myCreatures.getMyHeroStats());
                i--;
                stop--;
            }
        // check for item
            else if (myREntity.isItem(s)){
                myCreatures.giveItem(s);
                myMap.removeEntity(myCurrentLocation,s);
                i--;
                stop--;
            }
        }
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
        if(showCurrentRoom().contains("EXIT")){
            if (myCreatures.getMyHeroObjectives() == 4){
                return true;
            }
        }
        return false;

    }

    public boolean hasLost(){
        if(myCreatures.checkHeroAlive()){
           return false;
        }
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
