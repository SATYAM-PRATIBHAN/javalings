// I AM NOT DONE

public class Polymorphism1 {
    static class Animal {
        public String sound() { return "Generic sound"; }
    }

    static class Dog extends Animal {
        // 1. Override 'sound' to return "Bark"
        // YOUR CODE HERE
    }

    static class Cat extends Animal {
        // 2. Override 'sound' to return "Meow"
        // YOUR CODE HERE
    }

    // 3. Complete this method to demonstrate polymorphism.
    // It takes ANY Animal object and returns the result of its sound() method.
    public static String getAnimalSound(Animal animal) {
        // YOUR CODE HERE
        return "";
    }
}
