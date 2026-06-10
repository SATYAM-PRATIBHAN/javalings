// I AM NOT DONE

public class TypeCasting3 {
    // 1. Autoboxing and Unboxing.
    // You are given two Integer wrapper objects.
    // Unbox them to primitives, add them together, and return the result 
    // boxed inside a Long object.
    // Note: Be careful of integer overflow! Cast one of the ints to a long BEFORE adding.
    public static Long addAndBox(Integer a, Integer b) {
        // Your code here
        return null;
    }

    // 2. Precision Loss (Narrowing Conversion)
    // A database accidentally stored 64-bit 'long' IDs, but the old legacy system 
    // can only accept 32-bit 'int' IDs. 
    // Cast the long ID down to an int, and return it.
    // What happens if the long is larger than the maximum value of an int?
    public static int downcastId(long largeId) {
        // Your code here
        return 0;
    }
}
