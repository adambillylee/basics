import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 8/18/16.
 */
public class MinimumWindowSubStringTest {
    MinimumWindowSubString sol = new MinimumWindowSubString();

    @Test
    public void testMinWindow1() throws Exception {
        Assert.assertEquals(sol.minWindow("ADOBECODEBANC", "ABC"), "BANC");
    }

    @Test
    public void testMinWindow2() throws Exception {
        Assert.assertEquals(sol.minWindow("A", "AA"), "");
    }

    @Test
    public void testMinWindow3() throws Exception {
        Assert.assertEquals(sol.minWindow("A", "B"), "");
    }

    @Test
    public void testMinWindow4() throws Exception {
        Assert.assertEquals(sol.minWindow("AB", "A"), "A");
    }

    @Test
    public void testMinWindow5() throws Exception {
        Assert.assertEquals(sol.minWindow("AB", "B"), "B");
    }

    @Test
    public void testMinWindow6() throws Exception {
        Assert.assertEquals(sol.minWindow("ABC", "B"), "B");
    }

}