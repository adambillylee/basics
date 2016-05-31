import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/30/16.
 */
public class LongestIncreasingSubsequenceTest {
    LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();

    @Test
    public void lengthOfLIS1() throws Exception {
        int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, sol.lengthOfLIS(input));
    }

    @Test
    public void lengthOfLIS2() throws Exception {
        int[] input = {10};
        assertEquals(1, sol.lengthOfLIS(input));
    }

    @Test
    public void lengthOfLIS3() throws Exception {
        int[] input = {1,3,6,7,9,4,10,5,6};
        assertEquals(6, sol.lengthOfLIS(input));
    }
}