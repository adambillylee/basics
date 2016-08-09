import org.testng.annotations.Test;

/**
 * Created by adamli on 8/8/16.
 */
public class LongestCommonPrefixTest {
    LongestCommonPrefix sol = new LongestCommonPrefix();

    @Test
    public void testLongestCommonPrefix1() throws Exception {
        String input[] = {"11", "112", "1234"};
        System.out.println(sol.LongestCommonPrefix(input));
    }

    @Test
    public void testLongestCommonPrefix2() throws Exception {
        String input[] = {"112", "11", "1234"};
        System.out.println(sol.LongestCommonPrefix(input));
    }

}