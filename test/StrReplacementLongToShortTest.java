import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/13/16.
 */
public class StrReplacementLongToShortTest {

    @Test
    public void testReplace() throws Exception {
        String input = "student";
        String longStr = "den";
        String shortStr = "XX";

        String actual = StrReplacementLongToShort.replace(input, longStr, shortStr);
        String expected = "stuXXt";

        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceNull() throws Exception {
        String input = "student";
        String longStr = "den";
        String shortStr = "";

        String actual = StrReplacementLongToShort.replace(input, longStr, shortStr);
        String expected = "stut";

        assertEquals(expected, actual);
    }
}