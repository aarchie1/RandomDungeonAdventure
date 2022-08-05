package CreatureEntityModel;

/**
 * This class is used for any battle logic
 * @author Anthony Archie
 * @version 0.01
 */
public class BattleLogic {
    Hero myHero;
    Monster myMonster;

    public BattleLogic(final Hero theHero, final Monster theMonster) {
        myHero = theHero;
        myMonster = theMonster;
    }

    public int startBattle () {
        // Battle Loop, Continue as long as both hero and monster are alive
        // Each iteration through this loop is 1 round of battle
        while (myHero.getMyHitPoints() > 0 && myMonster.getMyHitPoints() > 0) {
            if(myHero.getMyAttackSpeed() >= myMonster.getMyAttackSpeed()){
                if(myHero.getMyAttackSpeed()  >= myMonster.getMyAttackSpeed() * 2 ){
                    attack(myHero, myMonster);
                    myHero.attackBehavior(myMonster);
                } else {
                    attack(myHero, myMonster);
                }
            } else {
                attack(myMonster, myHero);
            }
        }
        return myHero.getMyHitPoints();
    }

    private void attack(final DungeonCharacter theFirstCharacter , final DungeonCharacter theSecondCharacter) {
        theFirstCharacter.attackBehavior(theSecondCharacter);
        theSecondCharacter.attackBehavior(theFirstCharacter);
    }
}
