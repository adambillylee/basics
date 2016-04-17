import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/14/16.
 */
public class DedupSortedKeepOneArrayTest {
    @Test
    public void dedup1() throws Exception {
        int[] input = {1,1,2,2,3,5};
        int[] expected = {1,2,3,5};
        int[] actual = DedupSortedKeepOneArray.dedup(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void dedup2() throws Exception {
        int[] input = {1,2,3,5};
        int[] expected = {1,2,3,5};
        int[] actual = DedupSortedKeepOneArray.dedup(input);

        assertArrayEquals(expected, actual);
    }

}