package CreatureEntityModel;

/**
 * This Class is used to control all the CreatureEntities. (Dungeon Characters)
 * It needs all methods stubbed out
 * This Class is used to produce all the Dungeon Characters and provide the methods
 * to control them.
 * @author Anthony Archie
 * @version 1.0
 */
public class CreatureEntityController {

    public CreatureEntityController(){

    }

    /**
     * Need to make this iterate over the list of monster names.
     * @return
     */
    public String getCreatureName(){
        Monster m = new Gremlin();
        return m.getMyName();
    }
}
