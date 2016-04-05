import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/5/16.
 */
public class LongestNoDupSubstringTest {
    @Test
    public void lengthOfLongestSameSubstring() throws Exception {
        String input = "aa";
        assertEquals(1, LongestNoDupSubstring.lengthOfLongestSubstring(input));
    }


    @Test
    public void lengthOfLongestDiffSubstring() throws Exception {
        String input = "au";
        assertEquals(2, LongestNoDupSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    public void lengthOfLongestbackSubstring() throws Exception {
        String input = "pwwkew";
        assertEquals(3, LongestNoDupSubstring.lengthOfLongestSubstring(input));
    }
}