import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/2/16.
 */
public class WordBreakTest {
    @Test
    public void wordBreak() throws Exception {
        Set<String> wordDict  = new HashSet<>();
        wordDict.add("bob");
        wordDict.add("cat");
        wordDict.add("rob");

        String input1 = "bob";
        String input2 = "bobcat";
        String input3 = "catbob";
        String input4 = "bobrob";
        String input5 = "bobrox";

        assertTrue(WordBreak.wordBreak(input1, wordDict));
        assertTrue(WordBreak.wordBreak(input2, wordDict));
        assertTrue(WordBreak.wordBreak(input3, wordDict));
        assertTrue(WordBreak.wordBreak(input4, wordDict));
        assertFalse(WordBreak.wordBreak(input5, wordDict));
    }

}