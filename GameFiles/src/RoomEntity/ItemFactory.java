package RoomEntity;


public enum ItemFactory implements RoomEntity{

    HEALPOT,
    VISONPOT,
    OBJECTIVE,
    TRAP,
    DEVAMULET;

    /**
     * When called, returns the enum name as a string (ex: "OGER")
     * @return
     */
    @Override
    public String getMyName() {
        return "" + this.name();
    }

    static Item spawnItem(final ItemFactory theItem){
        Item myItem = null;
        switch (theItem) {
            case HEALPOT -> myItem = new Item(HEALPOT.toString());
            case VISONPOT -> myItem = new Item(VISONPOT.toString());
            case OBJECTIVE -> {
                myItem = new Item(OBJECTIVE.toString());
                myItem.setMyFlavorText("One of the four objectives");
            }
            case TRAP ->{
                myItem = new Item(TRAP.toString());
                myItem.setMyFlavorText("This room smell's terrible! It assaults your nose!");
            }
            case DEVAMULET -> {
                myItem = new Item(DEVAMULET.toString());
                myItem.setMyFlavorText("Used for testing purposes by the creators of this world");
            }
        }
        return  myItem;
    }

    @Override
    public String toString(){
        return this.toString();
    }
}
