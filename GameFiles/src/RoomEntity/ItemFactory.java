package RoomEntity;


public enum ItemFactory implements RoomEntity{

    HEALPOT,
    VISONPOT,
    OBJECTIVE,
    TRAP,
    EXIT,
    START,
    DEVAMULET;

    public static boolean isItem(final String theName) {
        ItemFactory[] arr = {HEALPOT,VISONPOT,OBJECTIVE,TRAP,DEVAMULET,EXIT,START};
        for (ItemFactory i : arr){
            if (i.toString() == theName){
                return true;
            }
        }
        return false;
    }

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
            case EXIT->{
                myItem = new Item(EXIT.toString());
                myItem.setMyFlavorText("The Exit to the maze!");
            }
            case START ->{
                myItem = new Item(START.toString());
                myItem.setMyFlavorText("The Start to the maze!");
            }

        }
        return  myItem;
    }
    static Item spawnItem(final String s){
        ItemFactory[] arr = {HEALPOT,VISONPOT,OBJECTIVE,TRAP,DEVAMULET,EXIT,START};
        if (isItem(s)){
            for (ItemFactory i : arr){
                if (i.toString() == s){
                    return spawnItem(i);
                }
            }
        }
        return new Item("ItemFactory Given bad string!");
    }

    @Override
    public String toString(){
        return this.toString();
    }
}
