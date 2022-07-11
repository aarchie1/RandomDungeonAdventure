package RoomModel;

import RoomEntity.RoomEntity;
import java.util.ArrayList;
import java.util.List;


public interface Room {


    void addEntity(RoomEntity e);

    List<RoomEntity> getMyEntitys();
    
    public String toString();


}
