package RoomEntity;

public enum DoorFactory implements RoomEntity {
    DOORUP,
    DOORDOWN,
    DOORLEFT,
    DOORRIGHT;


    static DoorFactory getDoor(final String s){
        DoorFactory myD = switch (s) {
            case "w" -> DOORUP;
            case "s" -> DOORDOWN;
            case "a" -> DOORLEFT;
            case "d" -> DOORRIGHT;
            default -> null;
        };
        return myD;
    }

    static Door spawnDoor(DoorFactory theDoor){
        Door newDoor = switch (theDoor) {
            case DOORUP ->newDoor = new Door("DOORUP");
            case DOORDOWN ->newDoor = new Door("DOORDOWN");
            case DOORLEFT ->newDoor = new Door("DOORLEFT");
            case DOORRIGHT ->newDoor = new Door("DOORRIGHT");
        };
        return newDoor;
    }

    @Override
    public String getMyName() {
        return this.toString();
    }
}
