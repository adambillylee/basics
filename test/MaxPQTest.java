import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 12/20/15.
 */
public class MaxPQTest {
    MaxPQStartWithOne sol = new MaxPQStartWithOne(5);

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(sol.isEmpty());

        sol.insert(3);
        sol.delMax();

        assertTrue(sol.isEmpty());
    }

    @Test
    public void testDelMax() throws Exception {
        int expected = 3;

        sol.insert(1);
        sol.insert(2);
        sol.insert(3);

        int actual = sol.delMax();

        assertEquals(expected, actual);

        sol.insert(-1);

        expected = 2;
        actual = sol.delMax();
        assertEquals(expected, actual);

        sol.insert(5);
        sol.insert(0);
        sol.insert(3);

        expected = 5;
        actual = sol.delMax();
        assertEquals(expected, actual);
    }

    @Test
    public void testInsert() throws Exception {

    }
}