package RoomEntity;

;

public enum DoorFactory implements RoomEntity {
    DOORUP,
    DOORDOWN;

    static RoomEntity getDoor(final String s){
        DoorFactory myD;
        switch (s) {
            case "w":
                myD = DOORUP;
                break;
            case "s":
                myD = DOORDOWN;
                break;

            default:
                myD = null;
                break;
        }
        return myD;
    }
}
