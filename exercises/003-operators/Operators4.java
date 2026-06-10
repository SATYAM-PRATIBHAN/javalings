// I AM NOT DONE

public class Operators4 {
    // In many systems, permissions are stored as integers where each bit represents a specific right.
    // For example:
    // READ  = 4 (binary 100)
    // WRITE = 2 (binary 010)
    // EXEC  = 1 (binary 001)

    // 1. Grant a new permission to a user.
    // Combine the current permissions with the new permission using bitwise OR (|).
    public static int grantPermission(int currentPermissions, int newPermission) {
        // Your code here
        return 0;
    }

    // 2. Check if a user has a specific permission.
    // Use bitwise AND (&). If the result equals the specific permission, they have it.
    public static boolean hasPermission(int currentPermissions, int specificPermission) {
        // Your code here
        return false;
    }

    // 3. Revoke a permission from a user.
    // Use bitwise AND (&) combined with bitwise NOT (~) to remove the permission.
    public static int revokePermission(int currentPermissions, int permissionToRevoke) {
        // Your code here
        return 0;
    }
}
