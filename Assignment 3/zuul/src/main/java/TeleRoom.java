import java.util.LinkedList;
import java.util.Random;

public class TeleRoom extends Room {

    private LinkedList<Room> allRooms; // list of all rooms

    public TeleRoom(String description) {
        super(description);
        allRooms = new LinkedList<Room>();
    }

    public void addRoom(Room r) { // adds room to list of all rooms
        allRooms.add(r);
    }

    @Override
    public Room getNext() { // returns a random room from the list of all rooms
        Random rdm = new Random();
        int n = rdm.nextInt(allRooms.size());
        return allRooms.get(n);
    }

    @Override
    public String getExits() { return "No exits. You must choose to teleport."; }

    @Override
    public boolean isTeleRoom() { return true; }
}
