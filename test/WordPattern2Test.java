import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by adamli on 8/24/16.
 */
public class WordPattern2Test {
    WordPattern2 sol;

    @BeforeMethod
    public void setUp() throws Exception {
        sol = new WordPattern2();
    }

    @Test
    public void testWordPatternMatch1() throws Exception {
        Assert.assertTrue(sol.wordPatternMatch("abab", "redblueredblue"));
    }

    @Test
    public void testWordPatternMatch2() throws Exception {
        Assert.assertTrue(sol.wordPatternMatch("aaaa", "asdasdasdasd"));
    }

    @Test
    public void testWordPatternMatch3() throws Exception {
        Assert.assertFalse(sol.wordPatternMatch("aabb", "xyzabcxzyabc"));
    }

    @Test
    public void testWordPatternMatch4() throws Exception {
        Assert.assertFalse(sol.wordPatternMatch("ab", "aa"));
    }

}