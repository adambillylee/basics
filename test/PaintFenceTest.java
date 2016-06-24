import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/23/16.
 */
public class PaintFenceTest {
    PaintFence sol = new PaintFence();

    @Test
    public void numWays() throws Exception {
        assertEquals(66, sol.numWays(4, 3));
    }

}