// I AM NOT DONE

public class Classes2 {
    // You are building a Library class to manage multiple library branches.
    // This exercise focuses on the difference between instance variables and static variables!

    static class Library {
        // 'totalBooksInSystem' is shared across ALL Library instances.
        static int totalBooksInSystem = 0;
        
        // 'libraryName' and 'bookCount' belong to a specific Library instance.
        String libraryName;
        int bookCount;

        // 1. Constructor: Takes a String 'name' and initializes 'libraryName'.
        // 'bookCount' should start at 0.
        public Library(String name) {
            // YOUR CODE HERE
        }

        // 2. Write the 'addBooks' method. Takes an int 'count'.
        // Add the 'count' to THIS library's 'bookCount', AND
        // add the 'count' to the shared 'totalBooksInSystem'.
        public void addBooks(int count) {
            // YOUR CODE HERE
        }

        // 3. Write a STATIC method named 'getTotalBooksInSystem'.
        // It should return the value of the static variable 'totalBooksInSystem'.
        // Replace 'void' with the correct return type!
        public static void getTotalBooksInSystem() {
            // YOUR CODE HERE
        }

        // 4. Write the 'transferBooks' method.
        // Takes another 'Library' object and an int 'count'.
        // If THIS library has enough 'bookCount' (>= count):
        //   - Subtract 'count' from THIS library.
        //   - Add 'count' to the 'otherLibrary'.
        //   - Return true.
        // Otherwise, return false.
        // (Note: This does not change 'totalBooksInSystem'!)
        public boolean transferBooks(Library otherLibrary, int count) {
            // YOUR CODE HERE
            return false;
        }
    }
}
