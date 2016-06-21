import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/21/16.
 */
public class RegularExpressionDFSTest {
    RegularExpressionDFS sol = new RegularExpressionDFS();

    @Test
    public void isMatch1() throws Exception {
        String s = "abdba";
        String p = "c*abdb*a";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch2() throws Exception {
        String s = "abdba";
        String p = "abd.*a";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch3() throws Exception {
        String s = "aab";
        String p = "c*a*b";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch4() throws Exception {
        String s = "aab";
        String p = "c*ab";

        assertFalse(sol.isMatch(s, p));
    }

    @Test
    public void isMatch5() throws Exception {
        String s = "a";
        String p = "ab*";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch6() throws Exception {
        String s = "bbbba";
        String p = ".*a*a";

        assertTrue(sol.isMatch(s, p));
    }

    @Test
    public void isMatch7() throws Exception {
        String s = "a";
        String p = ".*..a*";

        assertFalse(sol.isMatch(s, p));
    }

    @Test
    public void isMatch8() throws Exception {
        String s = "aa";
        String p = "a";

        assertFalse(sol.isMatch(s, p));
    }

    @Test
    public void isMatch9() throws Exception {
        String s = "aaaaaaaaaaaaab";
        String p = "a*a*a*a*a*a*a*a*a*a*c";

        assertFalse(sol.isMatch(s, p));
    }
    @Test
    public void isMatch10() throws Exception {
        String s = "";
        String p = "c*c*";

        assertTrue(sol.isMatch(s, p));
    }
}