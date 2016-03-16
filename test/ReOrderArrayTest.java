import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/15/16.
 */
public class ReOrderArrayTest {

    @Test
    public void testReorderOdd() throws Exception {
        int[] array = new int[]{1,2,3,4,5,6,7};
        int[] actual = ReOrderArray.reorder(array);

        int[] expected = new int[]{1,4,2,5,3,6,7};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void testReorderEven() throws Exception {
        int[] array = new int[]{1,2,3,4,5,6};
        int[] actual = ReOrderArray.reorder(array);

        int[] expected = new int[]{1,4,2,5,3,6};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testReorderEven2() throws Exception {
        int[] array = new int[]{1,2,3,4,5,6,7,8};
        int[] actual = ReOrderArray.reorder(array);

        int[] expected = new int[]{1,5,2,6,3,7,4,8};

        assertArrayEquals(expected, actual);
    }
}