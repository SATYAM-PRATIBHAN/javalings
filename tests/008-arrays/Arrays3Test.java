import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Arrays3Test {
    @Test
    public void testGetDiagonalSum() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assertEquals(15, Arrays3.getDiagonalSum(matrix)); // 1 + 5 + 9
    }

    @Test
    public void testCountGreaterThan() {
        int[][] grid = {
            {10, 20},
            {30, 5}
        };
        assertEquals(2, Arrays3.countGreaterThan(grid, 15)); // 20 and 30
    }
}
