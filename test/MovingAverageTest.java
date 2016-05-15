import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/14/16.
 */
public class MovingAverageTest {

    @Test
    public void next() throws Exception {
        MovingAverage sol = new MovingAverage(3);
        assertEquals(1, sol.next(1), 0.01);
    }

}