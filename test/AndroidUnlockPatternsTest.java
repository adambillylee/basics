import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/21/16.
 */
public class AndroidUnlockPatternsTest {
    AndroidUnlockPatterns sol = new AndroidUnlockPatterns();

    @Test
    public void testLength11() throws Exception {
        assertEquals(9, sol.numberOfPatterns(1, 1));
    }

    @Test
    public void testLengt22() throws Exception {
        assertEquals(56, sol.numberOfPatterns(2, 2));
    }

    @Test
    public void testLengt12() throws Exception {
        assertEquals(65, sol.numberOfPatterns(1, 2));
    }

    @Test
    public void testLengt33() throws Exception {
        assertEquals(320, sol.numberOfPatterns(3, 3));
    }

}