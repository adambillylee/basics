import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/21/16.
 */
public class AbbrevMatchTest {

    @Test
    public void isMatch() throws Exception {
        String input = "student";
        String pattern = "s2d2t";

        assertTrue(AbbrevMatch.isMatch(input, pattern));
    }

    @Test
    public void isMatch2() throws Exception {
        String input = "sophisticated";
        String pattern = "s11d";

        assertTrue(AbbrevMatch.isMatch(input, pattern));
    }
}