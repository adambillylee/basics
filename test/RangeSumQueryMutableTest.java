import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 6/6/16.
 */
public class RangeSumQueryMutableTest {
    RangeSumQueryMutable sol;

    @Test
    public void RangeSum1() throws Exception {
        sol = new RangeSumQueryMutable(new int[]{1, 2, 3, 4, 5});

        assertEquals(5, sol.sumRange(1, 2));
    }

    @Test
    public void RangeSum2() throws Exception {
        sol = new RangeSumQueryMutable(new int[]{1, 2, 3, 4, 5});

        assertEquals(5, sol.sumRange(1, 2));

        sol.update(1, 3);

        assertEquals(6, sol.sumRange(1, 2));

        sol.update(2, 0);

        assertEquals(3, sol.sumRange(1, 2));
    }

    @Test
    public void RangeSum3() throws Exception {
        sol = new RangeSumQueryMutable(new int[]{7,2,7,2,0});

        sol.update(4, 6);
        sol.update(0, 2);
        sol.update(0, 9);

        assertEquals(6, sol.sumRange(4, 4));

        sol.update(3, 8);
        assertEquals(32, sol.sumRange(0, 4));
    }

}