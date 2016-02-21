import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/16/16.
 */
public class ClosestElementTest {

    @Test
    public void testSearchFound() throws Exception {
        int input[] = {1,2,3,3,5,6};
        int target = 2;

        int expected = 2;
        int actual = ClosestElement.search(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchNotFound() throws Exception {
        int input[] = {1,2,3,3,5,6};
        int target = 4;

        int expected = 3;
        int actual = ClosestElement.search(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchOnlyOneElementFound() throws Exception {
        int input[] = {1};
        int target = 1;

        int expected = 1;
        int actual = ClosestElement.search(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchOnlyOneElementNotFound() throws Exception {
        int input[] = {1};
        int target = 4;

        int expected = 1;
        int actual = ClosestElement.search(input, target);

        assertEquals(expected, actual);
    }
}