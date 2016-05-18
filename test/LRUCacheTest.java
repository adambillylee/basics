import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/18/16.
 */
public class LRUCacheTest {
    LRUCache sol = new LRUCache(1);

    @Test
    public void addFirst() throws Exception {
        sol.set(1, 1);
        assertEquals(1, sol.get(1));
    }

    @Test
    public void update1() throws Exception {
        sol.set(1, 1);
        sol.set(2, 2);
        assertEquals(-1, sol.get(1));
        assertEquals(2, sol.get(2));
    }

    @Test
    public void update2() throws Exception {
        sol.set(2, 1);
        assertEquals(1, sol.get(2));
        sol.set(3, 2);
        assertEquals(-1, sol.get(2));
        assertEquals(2, sol.get(3));
    }


    @Test
    public void update3() throws Exception {
        sol = new LRUCache(2);
        assertEquals(-1, sol.get(2));
        sol.set(2, 6);
        assertEquals(-1, sol.get(1));
        sol.set(1, 5);
        sol.set(1, 2);
        assertEquals(2, sol.get(1));
        assertEquals(6, sol.get(2));
    }

    @Test
    public void update4() throws Exception {
        sol = new LRUCache(2);
        sol.set(2, 1);
        sol.set(1, 1);
        assertEquals(1, sol.get(2));
        sol.set(4, 1);
        assertEquals(-1, sol.get(1));
        assertEquals(1, sol.get(2));
    }
}