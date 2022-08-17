package RoomEntity;

import GameModel.Directions;

public enum WallFactory implements RoomEntity {
    WALLUP,
    WALLDOWN,
    WALLLEFT,
    WALLRIGHT;

    static WallFactory getWall(final String s) {
        Directions d = Directions.getDirection(s);
        return switch (d) {
            case UP -> WALLUP;
            case DOWN -> WALLDOWN;
            case LEFT -> WALLLEFT;
            case RIGHT -> WALLRIGHT;
            default -> null;
        };
    }
    public static WallFactory getWall(final Directions d) {
        return switch (d) {
            case UP -> WALLUP;
            case DOWN -> WALLDOWN;
            case LEFT -> WALLLEFT;
            case RIGHT -> WALLRIGHT;
            default -> null;
        };
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

    @Override
    public String toString() {
        return getMyName();
    }
}

