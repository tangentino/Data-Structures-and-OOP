import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private HashMap<String,Room> otherRooms;// creates a hashmap of neighbor rooms
    private LinkedList<String> itemList; // items in the room

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description){
        otherRooms = new HashMap<String,Room>();
        this.description = description;
        itemList = new LinkedList<String>();
    }

    public void setExit(String direction, Room neighbor) { // adds room to hashmap with direction as Key and neighbor as Value
        otherRooms.put(direction,neighbor);
    }

    // getter function since Game.getLocation() needs to access the directions

    public Room getNext() { // method exists so it can be overwritten in TeleRoom
        return otherRooms.get("north");
    }

    public Room getNeighbor(String direction) {
        return otherRooms.get(direction);
    }

    public String getExits() {
        String ans = "";
        for (String key : otherRooms.keySet() ) {
            ans += "| "+key + " |"; // added " | " to look nice :)
        }
        return ans;
    }

    public String getDescription()
    {
        return description;
    }

    public boolean isTeleRoom() { return false; } // method returns if room is a teleport room.

    //itemList methods

    public void addItem(String item) {
        itemList.add(item);
    }

    public void takeItems() {
        if (itemList.isEmpty()) {
            System.out.println("Nothing to loot!");
        }
        else {
            System.out.println("You loot all the items in this room");
            itemList.clear();
        }
    }

    public String getItems() {
        if (itemList.isEmpty()) {
            return "There are no items in this room";
        }
        return itemList.toString();
    }

    public String getItem(int index) {
        return itemList.get(index);
    }

    public int itemCount() {
        return itemList.size();
    }
}
