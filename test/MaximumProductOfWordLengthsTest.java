import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/24/16.
 */
public class MaximumProductOfWordLengthsTest {
    MaximumProductOfWordLengths sol = new MaximumProductOfWordLengths();

    @Test
    public void maxProduct1() throws Exception {
        String input[] = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        assertEquals(16, sol.maxProduct(input));
    }

    @Test
    public void maxProduct2() throws Exception {
        String input[] = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        assertEquals(4, sol.maxProduct(input));
    }

    @Test
    public void maxProduct3() throws Exception {
        String input[] = {"a", "aa", "aaa", "aaaa"};
        assertEquals(0, sol.maxProduct(input));
    }
}