import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/12/16.
 */
public class StrstrTest {

    @Test
    public void testStrStrFound() throws Exception {
        String s1 = "abcdefg";
        String s2 = "bcd";
        int actual = Strstr.strStr(s1, s2);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void testStrStrNotFound() throws Exception {
        String s1 = "abcdefg";
        String s2 = "bce";
        int actual = Strstr.strStr(s1, s2);
        int expected = -1;

        assertEquals(expected, actual);
    }
}