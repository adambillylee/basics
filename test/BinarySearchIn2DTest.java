import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/16/16.
 */
public class BinarySearchIn2DTest {

    @Test
    public void testBinarySearchFound() throws Exception {
        int input[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int target = 8;

        boolean actual = BinarySearchIn2D.BinarySearch(input, target);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearchNotFound() throws Exception {
        int input[][] = {{1,2,3},{5,6,7}};
        int target = 4;

        boolean actual = BinarySearchIn2D.BinarySearch(input, target);
        boolean expected = false;

        assertEquals(expected, actual);
    }
}