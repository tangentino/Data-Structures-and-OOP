import java.util.LinkedList;

public class Player {
//    private int health;
    private LinkedList<String> backpack; // list to store items
//    private int damage;
//    private boolean dead;

    public Player() {
//        health = 100;
        backpack = new LinkedList<String>();
//        damage = 10;
//        dead = false;
    }


    public void giveItem(String item) { // add item to backpack
        backpack.add(item);
    }

    public boolean hasItem(String item) { // check if item is in backpack
        return backpack.contains(item);
    }

    public void removeItem(String item) { // remove item from backpack
        backpack.remove(item);
    }

    public void openBackpack() { // prints all items in backpack
        if (backpack.isEmpty()) {
            System.out.println("Backpack is empty!");
        }
        else {
            System.out.println("Backpack: "+backpack.toString());
        }
    }

    public boolean emptyBackpack() { // check if backpack is empty
        return backpack.isEmpty();
    }

    public int backpackSize() {
        return backpack.size();
    }


// DEAD CODE: failed attempt at combat system

//    public boolean isDead() {
//        return dead;
//    }
//    public void damage(int n) { // damages player for n amount
//        health -= n;
//        if (health <= 0) {
//            dead = true;
//        }
//    }
//
//    public int attack() {
//        Random rdm = new Random();
//        return rdm.nextInt(damage) + 5; // roll random number from 5 to damage
//    }
}
