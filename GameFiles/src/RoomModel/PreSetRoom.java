package RoomModel;
import RoomEntity.EntityController;

import java.util.ArrayList;

enum PreSetRoom implements Room {
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
        }
        return  myItem;
    }


    @Override
    public void addEntity(String theEntityName) {

    }

    @Override
    public ArrayList<String> getMyEntities() {
        return null;
    }

    @Override
    public void removeEntity(String theTargetName) {

    }
    @Override
    public String toString(){
        return this.toString();
    }
}
