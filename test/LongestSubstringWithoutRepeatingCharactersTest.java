import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/14/16.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void testLongestSubStringNoDups() throws Exception {
        String input = "abcdefcbaga";

        String expected = "defcbag";
        String actual = LongestSubstringWithoutRepeatingCharacters.longestSubStringNoDups(input);

        assertEquals(expected, actual);
    }
}