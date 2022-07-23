package CreatureEntityModel;

public class BattleLogic {

    public Hero getCombatantOne (Hero theHero) {
        theHero.getMyName();
        theHero.getMyHitPoints();
        theHero.getMyBlockAccuracy();
        theHero.getMyRegularAttack();
        theHero.getMySpecialAttack();
        theHero.getMyAttackAccuracy();
        theHero.getMyAttackSpeed();
        theHero.getMyBlockAccuracy();

        return theHero;
    }



    /**
     * Upon initiating battle this method will check to see
     * who has higher attack speed.
     * @param theHero  takes in a hero entity
     * @param theMonster takes in a monster entity
     * @return the faster of the two
     */
    public String compareSpeed(Hero theHero, Monster theMonster) {
        int HeroSpeed = theHero.getMyAttackSpeed();
        int MonsterSpeed = theMonster.getMyAttackSpeed();

        if (HeroSpeed > MonsterSpeed) {
            return theHero.toString();
        } else if (HeroSpeed < MonsterSpeed) {
            return theMonster.toString();
        } else {
            return theHero.toString();
        }
    }


    // import copy of relevant stats
    // if 2 or more creatures are in same room
    // will loop through options
    // display as it goes through each loop
    // first win loss will be automated
    // prompt GAME CONTROLLER for player choice
    // Long term goal is to allow player to make choices
}
