package CreatureEntityModel;

import SQLite.SqlConnect;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This Class holds the templates for our monsters.
 * It should contain a spawn monster and the ENUMS for the different options.
 * It implements CreatureEntity's so that it can make them with spawnMonster
 */
public enum MonsterFactory implements CreatureEntity {
    GREMLIN, OGRE, SKELETON;

    private static ArrayList<Object> myGremlinList = SqlConnect.getGremlinList();
    private static ArrayList<Object> myOgreList = SqlConnect.getOgreList();
    private static ArrayList<Object> mySkeletonList = SqlConnect.getSkeletonList();

    public static Boolean IsMonster(final String theName) {
        String[] myMon = {"GREMLIN", "OGRE", "SKELETON"};
        for (String s:myMon) {
            if (s.equals(theName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * When called, returns the enum name as a string (ex: "OGER")
     * @return
     */
    @Override
    public String getMyName() {
        return this.toString();
    }

    static Monster spawnMonster(MonsterFactory theMon){

        Monster newMon = null;
        switch (theMon) {
            case GREMLIN ->newMon = new Monster(myGremlinList.get(0).toString(), (Integer) myGremlinList.get(1), (Integer) myGremlinList.get(2), (Integer) myGremlinList.get(3), (Integer) myGremlinList.get(4), (Double) myGremlinList.get(5),
                    (Double) myGremlinList.get(6), (Integer) myGremlinList.get(7), (Integer) myGremlinList.get(8));
            case OGRE ->newMon = new Monster(myOgreList.get(0).toString(), (Integer) myOgreList.get(1), (Integer) myOgreList.get(2), (Integer) myOgreList.get(3), (Integer) myOgreList.get(4), (Double) myOgreList.get(5),
                    (Double) myOgreList.get(6), (Integer) myOgreList.get(7), (Integer) myOgreList.get(8));
            case SKELETON ->newMon = new Monster(mySkeletonList.get(0).toString(), (Integer) mySkeletonList.get(1), (Integer) mySkeletonList.get(2), (Integer) mySkeletonList.get(3), (Integer) mySkeletonList.get(4), (Double) mySkeletonList.get(5),
                    (Double) mySkeletonList.get(6), (Integer) mySkeletonList.get(7), (Integer) mySkeletonList.get(8));

        }
        return newMon;
    }

    static void getMonsters(){

    }
}
