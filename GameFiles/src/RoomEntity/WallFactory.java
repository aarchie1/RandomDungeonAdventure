package RoomEntity;

public enum WallFactory implements RoomEntity {
    WALLUP,
    WALLDOWN,
    WALLLEFT,
    WALLRIGHT;

    static WallFactory getWall(final String s) {
        WallFactory myWall = switch (s) {
            case "w" -> WALLUP;
            case "s" -> WALLDOWN;
            case "a" -> WALLLEFT;
            case "d" -> WALLRIGHT;
            default -> null;
        };
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
        newWall.setMyFlavorText("A Wall");
        return newWall;
    }


    @Override
    public String getMyName() {
        return this.toString();
    }
}

