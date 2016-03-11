import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/10/16.
 */
public class DeduplicateAdjacentCharsRepeatlyTest {

    @Test
    public void testDedup() throws Exception {
        String input = "abbbbaz";

        String expected = "z";
        String actual = DeduplicateAdjacentCharsRepeatly.dedup(input);
        assertEquals(expected, actual);
    }
}