import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/3/16.
 */
public class UniquePathsTest {
    @Test
    public void testUniquePath() {
        assertEquals(1, UniquePaths.uniquePaths2D(2,1));
        assertEquals(1, UniquePaths.uniquePaths1D(2,1));

        assertEquals(3, UniquePaths.uniquePaths2D(3,2));
        assertEquals(3, UniquePaths.uniquePaths1D(3,2));

        assertEquals(6, UniquePaths.uniquePaths2D(3,3));
        assertEquals(6, UniquePaths.uniquePaths1D(3,3));
    }
}