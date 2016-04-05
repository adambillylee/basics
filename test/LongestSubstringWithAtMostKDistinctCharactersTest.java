import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/5/16.
 */
public class LongestSubstringWithAtMostKDistinctCharactersTest {
    @Test
    public void lengthOfLongestSubstringKDistinct() throws Exception {
        int k = 2;
        assertEquals(4, LongestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("eaeavg", k));
    }

}