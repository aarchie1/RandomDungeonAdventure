package RoomModel;

import RoomEntity.RoomEntity;

import java.util.ArrayList;
import java.util.List;

public enum PreSetRoom implements Room {
    START,
    EXIT,
    OBJECTIVE,
    GENERIC;


    @Override
    public void addEntity(String e) {
        myEntitys.add(e);
    }

    @Override
    public ArrayList<String> getMyEntities() {

        return myEntitys;
    }

    @Override
    public void removeEntity(String theTargetName) {
        if (myEntitys.contains(theTargetName)){
            myEntitys.remove(theTargetName);
        }
    }


}
