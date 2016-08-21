import org.testng.annotations.Test;

/**
 * Created by adamli on 8/21/16.
 */
public class PalindromeSubSequenceTest {
    PalindromeSubSequence sol = new PalindromeSubSequence();

    @Test
    public void testFindPalindrome1() throws Exception {
        System.out.println(sol.findPalindrome("aabba"));
    }

    @Test
    public void testFindPalindrome2() throws Exception {
        System.out.println(sol.findPalindrome("abcba"));
    }

}