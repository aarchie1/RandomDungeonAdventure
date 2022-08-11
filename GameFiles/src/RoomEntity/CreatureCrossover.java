package RoomEntity;

/**
 * This Class serves as the bridge between the CreatureEntityModel and the RoomEntityModel.
 * This Class should instantiate a CreatureEntityController in order to make use of the controller
 * to place monster and heroes in rooms as necessary.
 * @author Anthony Archie
 * @author Rowan W Osmon
 * @version 0.01
 */
import CreatureEntityModel.CreatureEntityController;

public class CreatureCrossover implements RoomEntity {

    public final CreatureEntityController myCreatureController;

    CreatureCrossover() {
        myCreatureController = new CreatureEntityController();
    }

    public CreatureEntityController getMyCreatureController() {
        return myCreatureController;
    }

    // Method to addMonster
    public void addMonster(){

        myCreatureController.createMonster("gremlin");
        myCreatureController.getMyMonster();
    }

    // Method to addMonster
    public void addHero(){
        myCreatureController.createHero("thief");
    }

    // Method to RemoveMonster
    public void removeMonster(final String theMonsterName){
        myCreatureController.removeMonster(theMonsterName);
    }

    @Override
    public String toString() {
        return getMyName();
    }


    @Override
    public String getMyName() {
        return myCreatureController.getMyMonster();
    }

}
