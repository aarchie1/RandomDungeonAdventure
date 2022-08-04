package RoomModel;

import RoomEntity.RoomEntity;

import java.util.List;

public enum PreSetRoom implements Room {
    START,
    EXIT,
    OBJECTIVE,
    GENERIC;


    @Override
    public void addEntity(String e) {

    }

    @Override
    public List<String> getMyEntities() {
        return null;
    }

    @Override
    public void removeEntity(String theTargetName) {

    }


}
