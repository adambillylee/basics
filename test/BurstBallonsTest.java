import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 6/28/16.
 */
public class BurstBallonsTest {
    BurstBallons sol = new BurstBallons();

    @Test
    public void testMaxCoins1() throws Exception {
        int nums[] = {3, 1, 5, 8};
        Assert.assertEquals(sol.maxCoins(nums), 167);
    }

    @Test
    public void testMaxCoins2() throws Exception {
        int nums[] = {3};
        Assert.assertEquals(sol.maxCoins(nums), 3);
    }

    @Test
    public void testMaxCoins3() throws Exception {
        int nums[] = {8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2};
        Assert.assertEquals(sol.maxCoins(nums), 3446);
    }

    @Test
    public void testMaxCoins4() throws Exception {
        int nums[] = {1, 2, 3};
        Assert.assertEquals(sol.maxCoins(nums), 12);
    }

}