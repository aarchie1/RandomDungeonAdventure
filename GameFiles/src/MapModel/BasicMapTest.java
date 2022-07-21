package MapModel;

import GameModel.Location;
import RoomModel.BasicRoom;
import RoomModel.Room;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class BasicMapTest {
    BasicMap myMap = new BasicMap();
    Location myStart = new Location(0,0);

    Location myCurrent = new Location(0,0);

    private void moveOffset(int theX, int theY){

        myCurrent = new Location(myStart.getMyX() + theX, myStart.getMyX()+theY);
    }
    @BeforeEach
    void setUp() {
        myMap = new BasicMap();
    }

    @org.junit.jupiter.api.Test
    void replaceRoom() {
        System.out.println("\n***Begin replaceRoom test***\n");
        System.out.println(myMap.getRoomAt(myStart).toString());
        fail("Not finished!");
    }

    @org.junit.jupiter.api.Test
    void generateRoom() {
        System.out.println("\n***Begin generateRoom test***\n");
        moveOffset(1,0);
        myMap.generateRoom(myCurrent);
        myMap.replaceRoom(myCurrent, new BasicRoom());
        fail("Not finished!");

    }

    @org.junit.jupiter.api.Test
    void fullMap() {
        System.out.println("\n***Begin fullMap test***\n");
        for (int i = 0; i < 5; i++){
            moveOffset(i,i);
            myMap.generateRoom(myCurrent);
            System.out.println(myMap.fullMap() + "\n");
        }
        fail("Not finished!");

    }

    @org.junit.jupiter.api.Test
    void getRoomAt() {
        System.out.println("\n***Begin getRoomAt test***\n");
        String expectedOut = "DevAmulet";
        Room test1 = myMap.getRoomAt(myStart);
        System.out.println(test1.toString());
        assertEquals(expectedOut, test1.toString());
        expectedOut = "EmptyRoom";
        moveOffset(1,1);
        test1 = myMap.getRoomAt(myCurrent);
        System.out.println(test1.toString());
        assertEquals(expectedOut, test1.toString());
        System.out.println("getRoomAt test passed!");
    }

    @org.junit.jupiter.api.Test
    void localMap() {
        String theExpectedString = "[EmptyRoom][EmptyRoom][EmptyRoom]\n" +
                "[EmptyRoom][DevAmulet][EmptyRoom]\n" +
                "[EmptyRoom][EmptyRoom][EmptyRoom]\n";
        String theMapOutput = "";
        System.out.println("\n***Begin localMap test***\n");
        System.out.println("Build a local map at the start tile");
        theMapOutput = myMap.localMap(myStart);
        System.out.println(theMapOutput);
        assertEquals(theExpectedString, theMapOutput);
        System.out.println("Build a local map at x-1, y-1");
        theExpectedString = "[EmptyRoom][EmptyRoom][EmptyRoom]\n" +
                "[EmptyRoom][EmptyRoom][EmptyRoom]\n" +
                "[EmptyRoom][EmptyRoom][DevAmulet]\n";
        moveOffset(-1,-1);
        theMapOutput = myMap.localMap(myCurrent);
        System.out.println(myMap.localMap(myCurrent));
        assertEquals(theExpectedString, theMapOutput);
        System.out.println("Map test finished!");
    }

}