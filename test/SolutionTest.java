import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 7/8/16.
 */
public class SolutionTest {
    @Test
    public void testAlienOrder1() throws Exception {
        Solution sol = new Solution();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        Assert.assertEquals(sol.alienOrder(words), "wertf");
    }

    @Test
    public void testAlienOrder2() throws Exception {
        Solution sol = new Solution();
        String[] words = {"ab", "adc"};
        Assert.assertEquals(sol.alienOrder(words), "bdca");
    }

    @Test
    public void testAlienOrderCycle1() throws Exception {
        Solution sol = new Solution();
        String[] words = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        Assert.assertEquals(sol.alienOrder(words), "");
    }

    @Test
    public void testAlienOrderCycle2() throws Exception {
        Solution sol = new Solution();
        String[] words = {"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"};
        Assert.assertEquals(sol.alienOrder(words), "");
    }

    @Test
    public void testAlienOrder3() throws Exception {
        Solution sol = new Solution();
        String[] words = {"ac", "ab", "b"};
        Assert.assertEquals(sol.alienOrder(words), "cab");
    }
}