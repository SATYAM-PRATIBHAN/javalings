// I AM NOT DONE

public class Interfaces2 {
    
    interface Movable {
        String move();
    }

    interface Chargeable {
        // 1. Add a 'default' method named 'getBatteryType' that returns "Lithium-Ion".
        // Default methods in interfaces provide a concrete implementation!
        // YOUR CODE HERE
        
        int getChargeLevel();
    }

    // 2. Make 'ElectricCar' implement BOTH 'Movable' and 'Chargeable'.
    static class ElectricCar {
        
        // 3. Implement the required 'move' method (return "Zoom!").
        // YOUR CODE HERE

        // 4. Implement the required 'getChargeLevel' method (return 100).
        // YOUR CODE HERE
    }
}
