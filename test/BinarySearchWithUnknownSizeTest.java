import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/16/16.
 */
public class BinarySearchWithUnknownSizeTest {
    @Test
    public void testSearchWithUnknownSizeFoundEven() throws Exception {
        int input[] = {1,2,3,4,5,6,7,8};
        int target = 5;
        BinarySearchWithUnknownSize.setSize(input.length);

        int expected = 4;
        int actual = BinarySearchWithUnknownSize.searchWithUnknownSize(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchWithUnknownSizeFoundOdd() throws Exception {
        int input[] = {1,2,3,4,5,6,7};
        int target = 7;
        BinarySearchWithUnknownSize.setSize(input.length);

        int expected = 6;
        int actual = BinarySearchWithUnknownSize.searchWithUnknownSize(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchWithUnknownSizeNotFoundEven() throws Exception {
        int input[] = {1,2,3,4,5,6,7,8};
        int target = 9;
        BinarySearchWithUnknownSize.setSize(input.length);

        int expected = -1;
        int actual = BinarySearchWithUnknownSize.searchWithUnknownSize(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchWithUnknownSizeNotFoundOdd() throws Exception {
        int input[] = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        BinarySearchWithUnknownSize.setSize(input.length);

        int expected = -1;
        int actual = BinarySearchWithUnknownSize.searchWithUnknownSize(input, target);

        assertEquals(expected, actual);
    }
}