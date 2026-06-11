// I AM NOT DONE

public class AccessModifiers1 {
    static class SystemConfig {
        // 1. Change this to 'private' so it cannot be accessed directly.
        public String adminPassword = "defaultPassword";

        // 2. Change this to 'protected' so subclasses can access it, but not the public.
        public int connectionTimeout = 30;

        // 3. Complete the public method 'updatePassword' that takes (String oldPass, String newPass).
        // If oldPass matches adminPassword, update it to newPass and return true.
        // Else return false.
        public boolean updatePassword(String oldPass, String newPass) {
            // YOUR CODE HERE
            return false;
        }
    }
}
