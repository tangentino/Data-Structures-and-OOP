import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords {

    private HashMap<String, CmdWord> validCommands; // hashmap that holds valid commands

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords(){
        validCommands = new HashMap<String,CmdWord>();
        validCommands.put("go",CmdWord.go);
        validCommands.put("help",CmdWord.help);
        validCommands.put("quit",CmdWord.quit);
        validCommands.put("look",CmdWord.look);
        validCommands.put("back",CmdWord.back);
        validCommands.put("scavenge",CmdWord.scavenge);
        validCommands.put("backpack",CmdWord.backpack);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        if (validCommands.containsKey(aString)) {
            return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
