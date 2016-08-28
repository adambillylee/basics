import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 8/27/16.
 */
public class SearchInRotatedArrayTest {
    SearchInRotatedArray sol = new SearchInRotatedArray();

    @Test
    public void testNormal() throws Exception {
        assertEquals(sol.found(new int[]{4,5,1,2,3}, 1), 2);
    }

    @Test
    public void testRotatedBoundary() throws Exception {
        assertEquals(sol.found(new int[]{4,5,1,2,3}, 4), 0);
        assertEquals(sol.found(new int[]{4,5,1,2,3}, 3), 4);
    }

    @Test
    public void testNotRotated() throws Exception {
        assertEquals(sol.found(new int[]{1,2,3,4,5}, 3), 2);
        assertEquals(sol.found(new int[]{1,2,3,4,5}, 1), 0);
        assertEquals(sol.found(new int[]{1,2,3,4,5}, 5), 4);
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(sol.found(new int[]{1}, 1), 0);
    }

    @Test
    public void testNotFound() throws Exception {
        assertEquals(sol.found(new int[]{1,2,3,4,5}, 6), -1);
    }

}