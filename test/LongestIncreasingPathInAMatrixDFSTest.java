import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/21/16.
 */
public class LongestIncreasingPathInAMatrixDFSTest {
    LongestIncreasingPathInAMatrixDFS sol = new LongestIncreasingPathInAMatrixDFS();

    @Test
    public void longestIncreasingPath1() throws Exception {
        int matrix[][] = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };

        assertEquals(4, sol.longestIncreasingPath(matrix));
    }

    @Test
    public void longestIncreasingPath2() throws Exception {
        int matrix[][] = {
                {3, 3, 2},
                {3, 2, 3},
                {3, 2, 2}
        };

        assertEquals(2, sol.longestIncreasingPath(matrix));
    }
}