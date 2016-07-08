import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 7/7/16.
 */
public class CustomedHashMapTest {

    @Test
    public void testPutAndGet() throws Exception {

        CustomedHashMap sol = new CustomedHashMap(5);
        assertTrue(sol.put(1, "1"));
        assertTrue(sol.put(2, "2"));
        assertTrue(sol.put(3, "3"));
        assertTrue(sol.put(4, "4"));
        assertTrue(sol.put(5, "5"));
        assertFalse(sol.put(6, "6"));

        assertEquals((String)sol.get(1), "1");
        assertEquals((String)sol.get(2), "2");
        assertEquals((String)sol.get(3), "3");
        assertEquals((String)sol.get(4), "4");
        assertEquals((String)sol.get(5), "5");
        assertEquals(sol.get(6), null);
    }

    @Test
    public void testRemove() throws Exception {
        CustomedHashMap sol = new CustomedHashMap(5);
        assertTrue(sol.put(1, "1"));
        assertTrue(sol.put(2, "2"));
        assertTrue(sol.put(3, "3"));
        assertEquals(sol.size, 3);

        assertTrue(sol.remove(1));
        assertEquals(sol.get(1), null);
        assertEquals(sol.size, 2);

        assertTrue(sol.remove(2));
        assertEquals(sol.get(2), null);
        assertEquals(sol.size, 1);

        assertTrue(sol.remove(3));
        assertEquals(sol.get(3), null);
        assertEquals(sol.size, 0);

        assertFalse(sol.remove(7));
        assertEquals(sol.get(7), null);

        assertTrue(sol.put(1, "1"));
        assertEquals((String)sol.get(1), "1");
        assertEquals(sol.size, 1);
    }

}