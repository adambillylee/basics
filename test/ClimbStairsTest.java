import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/4/16.
 */
public class ClimbStairsTest {
    @Test
    public void climbStairs() throws Exception {
        assertEquals(1, ClimbStairs.climbStairs(0));

        assertEquals(1, ClimbStairs.climbStairs(1));


        assertEquals(2, ClimbStairs.climbStairs(2));

        assertEquals(3, ClimbStairs.climbStairs(3));

        assertEquals(5, ClimbStairs.climbStairs(4));
    }

}