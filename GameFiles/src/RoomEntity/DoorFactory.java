package RoomEntity;



enum DoorFactory implements RoomEntity {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    @Override
    public String toString() {
      return getMyName();
    }

    @Override
    public String getMyName() {
        String dis = "";
        switch (this){
            case UP -> dis = "DOORUP";
            case DOWN -> dis ="DOORDOWN";
            case RIGHT -> dis = "DOORRIGHT";
            case LEFT -> dis = "DOORLEFT";
        }
        return dis;
    }


    static RoomEntity doorGen(final String theDirection) {
        DoorFactory theD = null;
        switch (theDirection){
            case "UP" -> theD = UP;
            case "DOWN" -> theD = DOWN;
            case "RIGHT" -> theD = RIGHT;
            case "LEFT" -> theD = LEFT;
        }
        return theD;
    }
}

