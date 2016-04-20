import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/18/16.
 */
public class PalindromePartitioningIITest {
    @Test
    public void minCut() throws Exception {
        String input = "aabaabca";

        int expected = 4;
        int actual = PalindromePartitioningII.minCut(input);

        assertEquals(expected, actual);
    }

}