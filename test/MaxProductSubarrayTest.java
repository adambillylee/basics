import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/5/16.
 */
public class MaxProductSubarrayTest {
    @Test
    public void maxProduct() throws Exception {
        int nums[] = {-1,-2,-9,-6};
        assertEquals(108, MaxProductSubarray.maxProduct(nums));
    }

}