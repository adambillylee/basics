import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/1/16.
 */
public class MaxIncreasingPathInMatrixTest {
    MaxIncreasingPathInMatrix sol = new MaxIncreasingPathInMatrix();

    @Test
    public void longestIncreasingPath() throws Exception {
        int input[][] = {{9,9,4},{6,6,8},{2,1,1}};
        assertEquals(4,sol.longestIncreasingPath(input));
    }

    @Test
    public void longestIncreasingPath2() throws Exception {
        int input[][] = {{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        assertEquals(7 ,sol.longestIncreasingPath(input));
    }

}