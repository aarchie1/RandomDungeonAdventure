package RoomEntity;

/**
 * This Class serves as the bridge between the CreatureEntityModel and the RoomEntityModel.
 * This Class should instantiate a CreatureEntityController in order to make use of the controller
 * to place monster and heroes in rooms as necessary.
 * @author Anthony Archie
 * @author Rowan W Osmon
 * @version .01
 */
import CreatureEntityModel.CreatureEntityController;

public class CreatureCrossover implements RoomEntity {

    public final CreatureEntityController myCreatureController;

    CreatureCrossover() {
        myCreatureController = new CreatureEntityController();
    }

    /**
     *
     * @return
     */
    public CreatureEntityController getMyCreatureController() {
        return myCreatureController;
    }

    // Method to addMonster
    public void addMonster(){

        myCreatureController.createMonster();
        myCreatureController.getMyMonster();
    }

    // Method to addMonster
    public void addHero(){
        myCreatureController.createHero();
    }



    @Override
    public String toString() {
        return myCreatureController.getMyMonster();
    }

}
