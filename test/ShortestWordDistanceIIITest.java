import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/13/16.
 */
public class ShortestWordDistanceIIITest {
    ShortestWordDistanceIII sol = new ShortestWordDistanceIII();

    @Test
    public void shortestWordDistance1() throws Exception {
        String words[] = {"a", "c", "a", "b", "a", "c", "b"};
        assertEquals(1, sol.shortestWordDistance(words, "b", "a"));
    }

    @Test
    public void shortestWordDistance2() throws Exception {
        String words[] = {"a", "a"};
        assertEquals(1, sol.shortestWordDistance(words, "a", "a"));
    }

    @Test
    public void shortestWordDistance3() throws Exception {
        String words[] = {"a", "b", "a"};
        assertEquals(2, sol.shortestWordDistance(words, "a", "a"));
    }

    @Test
    public void shortestWordDistance4() throws Exception {
        String words[] = {"b", "a", "a", "a"};
        assertEquals(1, sol.shortestWordDistance(words, "a", "a"));
    }
}