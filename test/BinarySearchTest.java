import org.intellij.lang.annotations.JdkConstants;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/15/16.
 */
public class BinarySearchTest {

    @Test
    public void testSearchFound() throws Exception {
        int[] input = new int[] {1,2,3,4,5,6};
        int target = 6;

        int actual = BinarySearch.search(input, target);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchNotFound() throws Exception {
        int[] input = new int[] {1,2,3,4,5,6};
        int target = 7;

        int actual = BinarySearch.search(input, target);
        int expected = -1;

        assertEquals(expected, actual);
    }
}