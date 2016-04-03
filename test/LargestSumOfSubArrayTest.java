import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/2/16.
 */
public class LargestSumOfSubArrayTest {
    @Test
    public void largestSumOfSubArray() throws Exception {
        int[] input = {1, 2, 4, -1, -2, 10, -1};
        int[] expected = {1, 2, 4, -1, -2, 10};
        assertArrayEquals(expected, LargestSumOfSubArray.LargestSumOfSubArray(input));
    }
}