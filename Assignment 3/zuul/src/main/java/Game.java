import java.util.LinkedList;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

//TODO LIST:
//Functional spaceship (with fuel and flight)
//Spaceship fuel : found in the horse farm
//Boss fight (on the moon)


public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    private Player character;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        character = new Player();
        createRooms();
        parser = new Parser();
    }


    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, hangar, abandoned, lab, farm, spaceship, spaceshipCockpit;
        TeleRoom teleport;

        //create items

        // create the rooms
        outside = new Room("outside somewhere");
        hangar = new Room("in a spaceship hangar that is here for some reason");
        abandoned = new Room("in an old, run-down looking building. Look around.");
        lab = new Room("in a really shady looking science lab. Look around.");
        farm = new Room("in... oh hey look it's a horse farm. Maybe you should look around.");
        spaceship = new Room("in a goddamn alien SPACESHIP");
        spaceshipCockpit = new Room("in the cockpit of the spaceship. You don't know how to fly it though.");

        // add items to rooms
        farm.addItem("horse glue");
        lab.addItem("scotch tape");
        abandoned.addItem("screwdriver");
        spaceshipCockpit.addItem("broken jetpack");

        // teleport room (spaceship not included on purpose)
        teleport = new TeleRoom("in a magical teleport room in the basement. Type 'go' to teleport to a random room.");
        teleport.addRoom(outside); teleport.addRoom(hangar); teleport.addRoom(abandoned); teleport.addRoom(lab); teleport.addRoom(farm);

        // initialise room exits
        outside.setExit("south",lab);
        outside.setExit("west",abandoned);
        outside.setExit("east",hangar);
        hangar.setExit("west",outside);
        hangar.setExit("east",spaceship);
        spaceship.setExit("west",hangar);
        spaceship.setExit("up",spaceshipCockpit);
        spaceshipCockpit.setExit("down",spaceship);
        abandoned.setExit("east",outside);
        abandoned.setExit("down",teleport);
        lab.setExit("north",outside);
        lab.setExit("east",farm);
        farm.setExit("west",lab);
        currentRoom = outside;
        previousRoom = outside; // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;

        while (! finished) {
            if (character.backpackSize() == 4) { // win condition if all items are collected
                System.out.println("You've collected all the items in the game.");
                System.out.println("You fix the broken jetpack with the tape, glue and screwdriver.");
                System.out.println("You use the jetpack to fly home safely.");
                System.out.println("Congratulations, you beat the game.");
                break;
            }
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(getLocation());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {

        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        switch (commandWord) {
            case ("help"):
                printHelp();

            case ("scavenge"):
                for (int i = 0; i < currentRoom.itemCount(); i++) {
                    character.giveItem(currentRoom.getItem(i));
                }
                currentRoom.takeItems();
                break;

            case ("go"):
                goRoom(command);
                break;

            case ("quit"):
                wantToQuit = quit(command);
                break;

            case ("look"):
                System.out.println(getLocation());
                System.out.println("Items found: " + currentRoom.getItems());
                System.out.println("Use the 'scavenge' command to loot items");
                break;

            case ("back"):
                if (currentRoom.isTeleRoom()) {
                    System.out.println("You can't back out of a teleport room!");
                } else {
                    Room temp = currentRoom;
                    currentRoom = previousRoom; // sets previousRoom to the last room you were in
                    previousRoom = temp;
                    System.out.println(getLocation());
                }
                break;

            case ("backpack"):
                character.openBackpack();
                break;

        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println("You somehow found yourself in the middle of");
        System.out.println("nowhere. Maybe you should explore and gather some items.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go | quit | help | look | back | scavenge | backpack"); // added " | " because it looks nice
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (currentRoom.isTeleRoom()) { // if currentRoom is a teleport room
            currentRoom = currentRoom.getNext(); // set currentRoom to a random room == teleport
            System.out.println("Whoosh! You teleported.");
            System.out.println(getLocation());
            return;
        }

        if(!command.hasSecondWord() & !currentRoom.isTeleRoom()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getNeighbor(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            previousRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(getLocation());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private String getLocation() { // prints location about current room
        StringBuilder locationInfo = new StringBuilder();
        locationInfo.append("You are " + currentRoom.getDescription());
        locationInfo.append('\n');
        locationInfo.append("Exits: ");
        locationInfo.append(currentRoom.getExits());
        return locationInfo.toString();
    }


}
