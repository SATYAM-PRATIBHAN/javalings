// I AM NOT DONE

// Base class and subclasses for the game inventory
class Item {}
class Weapon extends Item {
    int damage;
    Weapon(int d) { this.damage = d; }
}
class Potion extends Item {
    int healAmount;
    Potion(int h) { this.healAmount = h; }
}

public class TypeCasting2 {
    // 1. You receive a generic Item from the inventory.
    // You need to figure out what it is and use it!
    // - Check if the item is a Weapon using the 'instanceof' keyword.
    // - If it is a Weapon, cast it to a Weapon and return its damage.
    // - If it is a Potion, cast it to a Potion and return its healAmount * -1 (negative to represent healing).
    // - If it's neither, return 0.
    public static int processItem(Item item) {
        // Your code here
        return 0;
    }
}
