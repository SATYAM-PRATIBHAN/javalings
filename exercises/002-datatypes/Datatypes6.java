// I AM NOT DONE

public class Datatypes6 {
    public static int getScore() {
        // Wrapper classes like Integer can be null, but primitives like int cannot.
        // Fix this so it doesn't throw a NullPointerException when unboxed!
        Integer wrapperScore = null;
        int primitiveScore = wrapperScore;
        return primitiveScore;
    }
}
