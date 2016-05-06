import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/5/16.
 */
public class PalindromeNumberTest {
    PalindromeNumber sol = new PalindromeNumber();

    @Test
    public void isPalindrome1() throws Exception {
        int input = 52325;
        assertTrue(sol.isPalindrome(input));
    }

    @Test
    public void isPalindrome2() throws Exception {
        int input = 52345;
        assertFalse(sol.isPalindrome(input));
    }

    @Test
    public void isPalindrome3() throws Exception {
        int input = 0;
        assertTrue(sol.isPalindrome(input));
    }

}