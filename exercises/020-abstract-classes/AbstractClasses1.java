// I AM NOT DONE

public class AbstractClasses1 {
    
    // 1. Make the 'Shape' class abstract.
    static class Shape {
        
        // 2. Make the 'getArea' method abstract (it should have no body).
        public double getArea() { return 0.0; } // Fix this
    }

    static class Square extends Shape {
        double side;
        public Square(double side) { this.side = side; }

        // 3. Implement the 'getArea' method for a Square (side * side).
        // YOUR CODE HERE
    }

    static class Circle extends Shape {
        double radius;
        public Circle(double radius) { this.radius = radius; }

        // 4. Implement the 'getArea' method for a Circle (Math.PI * radius * radius).
        // YOUR CODE HERE
    }
}
