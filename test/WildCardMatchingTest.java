import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by adamli on 5/10/16.
 */
public class WildCardMatchingTest {
    WildCardMatching sol = new WildCardMatching();

    @Test
    public void isMatch1() throws Exception {
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String p = "a*******b";

        assertFalse(sol.isMatch(s, p));
    }

    @Test
    public void isMatch2() throws Exception {
        String s = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
        String p = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch3() throws Exception {
        String s = "abb";
        String p = "*b*";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch4() throws Exception {
        String s = "";
        String p = "";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch5() throws Exception {
        String s = "b";
        String p = "*?*?*";

        assertFalse(sol.isMatch(s, p));
    }

    @Test
    public void isMatch6() throws Exception {
        String s = "";
        String p = "*";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch7() throws Exception {
        String s = "aa";
        String p = "*";

        assertTrue(sol.isMatch(s, p));
    }

}