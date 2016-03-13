import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/13/16.
 */
public class StrReplacementShortToLongTest {

    @Test
    public void testReplace1() throws Exception {
        String input = "12345346347";
        String shortStr = "34";
        String longStr = "abc";

        String actual = StrReplacementShortToLong.replace(input, shortStr, longStr);
        String expected = "12abc5abc6abc7";

        assertEquals(expected, actual);
    }

    @Test
    public void testReplace2() throws Exception {
        String input = "yahoo/?q=flo wer market";
        String shortStr = " ";
        String longStr = "20%";

        String actual = StrReplacementShortToLong.replace(input, shortStr, longStr);
        String expected = "yahoo/?q=flo20%wer20%market";

        assertEquals(expected, actual);
    }
}