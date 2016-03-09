import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/6/16.
 */
public class RemoveCharFromStringTest {

    @Test
    public void testRemoveChar() throws Exception {
        String input = "student";
        char[] toRemove = {'u','n'};

        String expected = "stdet";
        String actual = RemoveCharFromString.removeChar(input, toRemove);

        assertEquals(expected, actual);
    }
}