import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/10/16.
 */
public class StringReverseTest {

    @Test
    public void testReverseRecursive() throws Exception {
        String input = "apple";

        String expected = "elppa";
        String actual = StringReverse.reverseRecursive(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testReverseIterative() throws Exception {
        String input = "apple";

        String expected = "elppa";
        String actual = StringReverse.reverseIterative(input);

        assertEquals(expected, actual);
    }
}