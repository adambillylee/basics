import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 7/17/16.
 */
public class MultiplyStringTest {
    MultiplyString sol = new MultiplyString();

    @Test
    public void testStrStrFound() throws Exception {
        String s1 = "11";
        String s2 = "22";

        Assert.assertEquals(sol.multiply(s1, s2), "242");
    }

}