package CreatureEntityModel;

/**
 * This Class holds the templates for heros.
 * It should contain a spawn hero and the ENUMS for the different options.
 * It implements CreatureEntity's so that it can make them with spawnHero
 * @author Anthony Archie
 * @version .01
 */
public enum HeroFactory implements CreatureEntity {
    THIEF, WARRIOR, PRIESTESS;

    /**
     * When called, returns the enum name as a string (ex: "OGER")
     * @return
     */
    @Override
    public String getMyName() {
        return "" + this;
    }

    static Hero spawnHero(HeroFactory theHero){
        Hero newHero = null;
        switch (theHero) {
            case THIEF ->newHero = new Hero("Thief", 75, 20, 40, 6,
                    .8, .4, "Pick Pocket", "Surpise Attack");
            case WARRIOR ->newHero = new Hero("Warrior", 125, 30, 60,
                    4, .8, .2, "War Hammer", "Crushing Blow");
            case PRIESTESS ->newHero = new Hero("Priestess",75, 25, 45, 5,
                    .7, .3, "Health Drain", "Heal");
        }
        return newHero;
    }
}
