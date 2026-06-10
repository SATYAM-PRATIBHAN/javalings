// I AM NOT DONE

public class Methods2 {
    // Java passes primitives by value. This means modifying a parameter inside
    // a method doesn't change the original variable outside the method.
    //
    // 1. Fix this method so it successfully increases the player's score by 10.
    // You cannot change the method signature of the test, but you MUST change the 
    // return type and return the new score instead of modifying it fruitlessly.
    public static void levelUpScore(int score) {
        score = score + 10;
        // Fix this
    }

    // 2. You can call other methods from within a method!
    // Complete the method 'doubleLevelUpScore' below.
    // It should first call 'levelUpScore' with the given score to increase it by 10,
    // and then multiply THAT result by 2, returning the final value.
    
    public static int doubleLevelUpScore(int score) {
        // YOUR CODE HERE
        return 0;
    }
}
