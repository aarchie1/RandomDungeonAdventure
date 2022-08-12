package RoomEntity;

public enum DoorFactory implements RoomEntity {
    DOORUP,
    DOORDOWN,
    DOORLEFT,
    DOORRIGHT;


    static RoomEntity getDoor(final String s){
        DoorFactory myD;
        switch (s) {
            case "w":
                myD = DOORUP;
                break;
            case "s":
                myD = DOORDOWN;
                break;
            case "a":
                myD = DOORLEFT;
                break;
            case "d":
                myD = DOORRIGHT;
                break;
            default:
                myD = null;
                break;
        }
        return myD;
    }

    static Door spawnDoor(DoorFactory theDoor){
        Door newDoor = null;
        switch (theDoor) {
            case DOORUP ->newDoor = new Door("Up");
            case DOORDOWN ->newDoor = new Door("Down");
            case DOORLEFT ->newDoor = new Door("Left");
            case DOORRIGHT ->newDoor = new Door("Right");
        }
        return newDoor;
    }

    @Override
    public String getMyName() {
        return this.toString();
    }
}
