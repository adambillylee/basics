import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/25/16.
 */
public class RangeSumQueryTest {
    RangeSumQuery sol;

    @Test
    public void sumRange() throws Exception {
        int nums[] = {1, 1, 1, 1};
        sol = new RangeSumQuery(nums);

        assertEquals(2, sol.sumRange(1,2));
    }

}