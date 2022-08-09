package RoomEntity;


public enum ItemFactory implements RoomEntity{

    HEALPOT,
    VISONPOT,
    OBJECTIVE,
    DEVAMULET;

    /**
     * When called, returns the enum name as a string (ex: "OGER")
     * @return
     */
    @Override
    public String getMyName() {
        return "" + this;
    }

    static Item spawnItem(final ItemFactory theItem){
        Item myItem = null;
        switch (theItem) {
            case HEALPOT -> myItem = new Item(HEALPOT.toString());
            case VISONPOT -> myItem = new Item(VISONPOT.toString());
            case OBJECTIVE -> myItem = new Item(OBJECTIVE.toString());
            case DEVAMULET -> myItem = new DevAmulet();
        }
        return  myItem;
    }

    @Override
    public String toString(){
        String myName = "";
        switch(this){
            case VISONPOT -> myName = "VISIONPOT";
            case HEALPOT -> myName ="HEALPOT";
            case OBJECTIVE -> myName = "OBJECTIVE";
        }
        return myName;
    }
}
