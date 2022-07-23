package CreatureEntityModel;

public class BattleLogic {

    /**
     * Copies stats of a Hero
     * @param theHero
     * @return
     */
    public Hero heroFightStats (Hero theHero) {
        String heroName = theHero.getMyName();
        int heroHitPoints = theHero.getMyHitPoints();
        double heroBlockAccuracy = theHero.getMyBlockAccuracy();
        String heroRegularAttack = theHero.getMyRegularAttack();
        String heroSpecialAttack = theHero.getMySpecialAttack();
        double heroAttackAccuracy = theHero.getMyAttackAccuracy();
        int heroAttackSpeed = theHero.getMyAttackSpeed();
        return theHero;
    }

    /**
     * Copies stats of Monster
     * @param theMonster
     * @return
     */
    public Monster monsterFightStats (Monster theMonster) {
        String monsterName = theMonster.getMyName();
        int monsterHitPoints = theMonster.getMyHitPoints();
        int monsterAttackSpeed = theMonster.getMyAttackSpeed();
        double monsterAttackAccuracy = theMonster.getMyAttackAccuracy();
        double monsterHealingPercentage = theMonster.getMyHealingPercentage();
        return theMonster;
    }



    /**
     * Upon initiating battle this method will check to see
     * who has higher attack speed.
     * @param theHero  takes in a hero entity
     * @param theMonster takes in a monster entity
     * @return the faster of the two
     */
    public String compareSpeed(Hero theHero, Monster theMonster) {
        int heroSpeed = theHero.getMyAttackSpeed();
        int monsterSpeed = theMonster.getMyAttackSpeed();

        if (heroSpeed > monsterSpeed) {
            return "Hero";
        } else if (heroSpeed < monsterSpeed) {
            return "Monster";
        } else {
            return "Hero";
        }
    }

    public void theFight (Hero heroFightStats, Monster monsterFightStats) {
        if (compareSpeed(heroFightStats,monsterFightStats).equals("Hero")) {
            while(heroFightStats.getMyHitPoints() > 0 | monsterFightStats.getMyHitPoints() > 0) {
                if(heroFightStats.getMyAttackAccuracy() > .50) {
                    //monsterFightStats.getMyHitPoints() -= heroFightStats.getMyRegularAttack();
                }
            }
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
