import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/17/16.
 */
public class KthLargestElementInAnArrayTest {
    @Test
    public void findKthLargest() throws Exception {
        int nums[] = {3,2,1,5,6,4};
        int k = 2;

        int actual = KthLargestElementInAnArray.findKthLargest(nums, k);

        assertEquals(5, actual);
    }

}