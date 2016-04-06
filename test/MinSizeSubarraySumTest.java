import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/5/16.
 */
public class MinSizeSubarraySumTest {
    @Test
    public void minSubArrayLen() throws Exception {
        int input[] = {2,3,1,2,4,3};
        assertEquals(2, MinSizeSubarraySum.minSubArrayLen(7, input));
    }

}