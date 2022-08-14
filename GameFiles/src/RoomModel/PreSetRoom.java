package RoomModel;
import RoomEntity.EntityController;

import java.util.ArrayList;

enum PreSetRoom {
    STARTROOM,
    EXITROOM,
    OBJECTIVEROOM,
    GENERICROOM;

    static BasicRoom spawnRoom(final PreSetRoom theItem){
        EntityController ec = new EntityController();
        BasicRoom myItem = new BasicRoom();
        switch (theItem) {
            case STARTROOM->{
                myItem = new BasicRoom(ec.getStartingRoom());
            }
            case EXITROOM-> {
                myItem = new BasicRoom(ec.getEndRoom());
            }
            case OBJECTIVEROOM -> {
                myItem = new BasicRoom(ec.getObjectiveRoom());
            }
            case GENERICROOM -> {
                myItem = new BasicRoom(ec.getRandomRoom());
            }
        }
        return  myItem;
    }

    @Override
    public String toString(){
        return this.toString();
    }
}
