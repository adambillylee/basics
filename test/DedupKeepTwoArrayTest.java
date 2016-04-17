import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/14/16.
 */
public class DedupKeepTwoArrayTest {
    @Test
    public void dedup() throws Exception {
        int[] input = {1,1,1,2,2,3,4,5};
        int[] expected = {1,1,2,2,3,4,5};

        assertArrayEquals(expected, DedupKeepTwoArray.dedupIncludeSlow(input));
        assertArrayEquals(expected, DedupKeepTwoArray.dedupNotIncludeSlow(input));
    }

}