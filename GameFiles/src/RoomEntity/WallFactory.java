package RoomEntity;

public enum WallFactory implements RoomEntity {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    public String toString(){
        return getMyName();
    }
    @Override
    public String getMyName() {
        String dis = "";
        switch (this){
            case UP -> dis = "WALLUP";
            case DOWN -> dis ="WALLDOWN";
            case RIGHT -> dis = "WALLRIGHT";
            case LEFT -> dis = "WALLLEFT";
        }
        return dis;
    }


    static RoomEntity wallGen(final String theDirection) {
        WallFactory theD = null;
        switch (theDirection){
            case "UP" -> theD = UP;
            case "DOWN" -> theD = DOWN;
            case "RIGHT" -> theD = RIGHT;
            case "LEFT" -> theD = LEFT;
        }
        return theD;
    }


}
