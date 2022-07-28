package CreatureEntityModel;

import java.util.Random;


/**
 * This class is used for any battle logic
 * @author Gil Rabara
 * @version 0.01
 * Gil's Notes
 * This class takes in Hero and Monster stats from CreatureEntityController
 * Checks to see if A Hero and a Monster Type are in the same room
 * If yes: Battle will automatically take place
 * Will record if Hero or Monster dies (HP > 0)
 * Will update Hero HP at end of battle
 */
public class BattleLogic {

    /*
     * method that exports hero HP if hero is alive
     */

    /**
     * Constructor
     */
    public BattleLogic() {

    }


    public int theFight (Hero heroInfo, Monster monsterInfo) {
        Random randoNum = new Random(); // Random number generator
       // CreatureEntityController cec = new CreatureEntityController();

        while(heroInfo.getMyHitPoints() > 0 && monsterInfo.getMyHitPoints() > 0) {
                if(heroInfo.getMyAttackAccuracy() > randoNum.nextDouble()) {
                    monsterInfo.setDamage(Integer.parseInt(heroInfo.getMyRegularAttack()));
                    //cec.checkAlive()
                }

            }
        // if HeroHP >= 0 then return 0;
        //return heroHP
        return 1;
    }


    // import copy of relevant stats
    // if 2 or more creatures are in same room
    // will loop through options
    // display as it goes through each loop
    // first win loss will be automated
    // prompt GAME CONTROLLER for player choice
    // Long term goal is to allow player to make choices
}
