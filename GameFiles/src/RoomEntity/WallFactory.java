package RoomEntity;

public enum WallFactory implements RoomEntity {
    WALLUP,
    WALLDOWN,
    WALLLEFT,
    WALLRIGHT;

    static RoomEntity getWall(final String s) {
        WallFactory myWall;
        switch (s) {
            case "w":
                myWall = WALLUP;
                break;
            case "s":
                myWall = WALLDOWN;
                break;
            case "a":
                myWall = WALLLEFT;
                break;
            case "d":
                myWall = WALLRIGHT;
                break;
            default:
                myWall = null;
                break;
        }
        return myWall;
    }

    static Wall spawnWall(WallFactory theWall) {
        Wall newWall = null;
        switch (theWall) {
            case WALLUP -> newWall = new Wall("WALLUP");
            case WALLDOWN -> newWall = new Wall("WALLDOWN");
            case WALLLEFT -> newWall = new Wall("WALLLEFT");
            case WALLRIGHT -> newWall = new Wall("WALLRIGHT");
        }
        return newWall;
    }


    @Override
    public String getMyName() {
        return null;
    }
}

