import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/2/16.
 */
public class PerfectSquaresTest {
    PerfectSquares sol = new PerfectSquares();

    @Test
    public void numSquares10() throws Exception {
        assertEquals(2, sol.numSquares(10));
    }

    @Test
    public void numSquares7() throws Exception {
        assertEquals(4, sol.numSquares(7));
    }

    @Test
    public void numSquaresMinus1() throws Exception {
        assertEquals(0, sol.numSquares(-1));
    }

    @Test
    public void numSquaresMinus12() throws Exception {
        assertEquals(3, sol.numSquares(12));
    }
}