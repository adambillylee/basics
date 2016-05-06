import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/5/16.
 */
public class ShortestPalindromeTest {
    ShortestPalindrome sol = new ShortestPalindrome();

    @Test
    public void shortestPalindrome1() throws Exception {
        String input = "abacc";
        assertEquals("ccabacc", sol.shortestPalindrome(input));
    }

    @Test
    public void shortestPalindrome2() throws Exception {
        String input = "abcd";
        assertEquals("dcbabcd", sol.shortestPalindrome(input));
    }

    @Test
    public void shortestPalindrome3() throws Exception {
        String input = "";
        assertEquals("", sol.shortestPalindrome(input));
    }

    @Test
    public void shortestPalindrome4() throws Exception {
        String input = "aba";
        assertEquals("aba", sol.shortestPalindrome(input));
    }
}