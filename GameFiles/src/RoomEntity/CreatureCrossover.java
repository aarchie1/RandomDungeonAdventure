package RoomEntity;


import CreatureEntityModel.CreatureEntityController;

public class CreatureCrossover implements RoomEntity {

    CreatureEntityController myCreature = new CreatureEntityController();

    CreatureCrossover(){

    }

    @Override
    public String toString() {
        return myCreature.getCreatureName();
    }
}
