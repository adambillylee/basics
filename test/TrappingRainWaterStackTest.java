import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 7/17/16.
 */
public class TrappingRainWaterStackTest {
    TrappingRainWaterStack sol = new TrappingRainWaterStack();

    @Test
    public void testTrap() throws Exception {
        int input[] = {2,0,2};
        Assert.assertEquals(sol.trap(input), 2);
    }

}