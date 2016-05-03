import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/1/16.
 */
public class MaxSizeSubArraySumEqualsKTest {
    MaxSizeSubArraySumEqualsK sol = new MaxSizeSubArraySumEqualsK();

    @Test
    public void maxSubArrayLen() throws Exception {
        int input[] = {-2, -1, 2, 1};
        int k = 1;

        assertEquals(2, sol.maxSubArrayLen(input, 1));
    }

}