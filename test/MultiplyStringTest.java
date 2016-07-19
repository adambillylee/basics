import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 7/17/16.
 */
public class MultiplyStringTest {
    MultiplyString sol = new MultiplyString();

    @Test
    public void testMultipleString() throws Exception {
        String s1 = "11";
        String s2 = "22";

        Assert.assertEquals(sol.multiply(s1, s2), "242");
    }
    @Test
    public void testMultipleZero() throws Exception {
        String s1 = "11";
        String s2 = "0";

        Assert.assertEquals(sol.multiply(s1, s2), "0");
    }

}