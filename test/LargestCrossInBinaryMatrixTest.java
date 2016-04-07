import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/6/16.
 */
public class LargestCrossInBinaryMatrixTest {
    @Test
    public void findCross() throws Exception {
        int [][] input = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {0,1,1,1}
        };

        assertEquals(2, LargestCrossInBinaryMatrix.findCross(input));
    }

}