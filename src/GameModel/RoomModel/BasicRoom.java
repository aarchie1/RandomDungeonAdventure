package RoomModel;

import RoomEntity.RoomEntity;
import RoomModel.Room;

import java.util.ArrayList;
import java.util.List;

public class BasicRoom implements Room {

    private List<RoomEntity> myEntitys = null;

    BasicRoom(ArrayList<RoomEntity> arr){
        myEntitys = arr;
    }

    public void setMyEntitys(ArrayList<RoomEntity> arr) {
        myEntitys = arr;
    }

    public List<RoomEntity> getMyEntitys(){
        return myEntitys;
    }

    @Override
    public void addEntity(RoomEntity e) {
        myEntitys.add(e);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (RoomEntity r : myEntitys) {
            sb.append(r.toString());
        }
        return sb.toString();
    }
}
