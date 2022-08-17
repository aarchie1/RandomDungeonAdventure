package RoomEntity;

import GameModel.Directions;

public enum DoorFactory implements RoomEntity {
    DOORUP,
    DOORDOWN,
    DOORLEFT,
    DOORRIGHT;


    public static DoorFactory getDoor(final String s) {
        DoorFactory df;
        switch (s) {
            case "DOORUP" -> {
                return DOORUP;
            }
            case "DOORDOWN" -> {
                return DOORDOWN;
            }
            case "DOORLEFT" -> {
                return DOORLEFT;
            }
            case "DOORRIGHT" -> {
                return DOORRIGHT;
            }
        }
        Directions d = Directions.getDirection(s);
        return switch (d) {
            case UP -> DOORUP;
            case DOWN -> DOORDOWN;
            case LEFT -> DOORLEFT;
            case RIGHT -> DOORRIGHT;
        };
    }

    public static DoorFactory getDoor(Directions d) {
        return switch (d) {
            case UP -> DOORUP;
            case DOWN -> DOORDOWN;
            case LEFT -> DOORLEFT;
            case RIGHT -> DOORRIGHT;
        };
    }


    /**
     * This Switch spawns one of our doors when called on
     *
     * @param theDoor the door type that you want
     * @return a door RoomEntity
     */
    static Door spawnDoor(DoorFactory theDoor) {
        return switch (theDoor) {
            case DOORUP -> new Door("DOORUP");
            case DOORDOWN -> new Door("DOORDOWN");
            case DOORLEFT -> new Door("DOORLEFT");
            case DOORRIGHT -> new Door("DOORRIGHT");
        };
    }

    @Override
    public String getMyName() {
        return this.toString();
    }
}
