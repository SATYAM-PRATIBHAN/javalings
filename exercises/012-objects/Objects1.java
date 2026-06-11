// I AM NOT DONE

public class Objects1 {
    
    static class Car {
        boolean engineRunning = false;
        int mileage = 0;

        public void startEngine() {
            engineRunning = true;
        }

        public void drive(int miles) {
            if (engineRunning) mileage += miles;
        }
    }

    // 1. Complete the method 'createAndDrive' that returns a Car object.
    // Inside the method:
    // - Instantiate a new Car object.
    // - Start its engine.
    // - Drive it for 50 miles.
    // - Return the Car object.
    public static Car createAndDrive() {
        // YOUR CODE HERE
        return null;
    }
}
