package CreatureEntityModel;

/**
 * This Class holds the templates for our monsters.
 * It should contain a spawn monster and the ENUMS for the different options.
 * It implements CreatureEntity's so that it can make them with spawnMonster
 */
public enum MonsterTemplates implements CreatureEntity {
    GREMLIN, OGRE, SKELETON;

    /**
     * When called, returns the enum name as a string (ex: "OGER")
     * @return
     */
    @Override
    public String getMyName() {
        return "" + this;
    }

    static Monster spawnMonster(MonsterTemplates theMon){
        Monster newMon = null;
        switch (theMon) {
            case GREMLIN ->newMon = new Monster("Gizmo The Gremlin", 70, 15, 30,
                    5, .8, .4,
                    20, 40);
            case OGRE ->newMon = new Monster("Shrek the Ogre", 200, 30, 60,2,
                    .6, .1, 30, 60);
            case SKELETON ->newMon = new Monster("Gravelord the Skeleton", 100, 30, 50,
                    3, .8, .3, 30, 50);

        }
        return newMon;
    }
}
