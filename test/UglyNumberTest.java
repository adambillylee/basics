import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/14/16.
 */
public class UglyNumberTest {
    UglyNumber sol = new UglyNumber();

    @Test
    public void isUgly1() throws Exception {
        Assert.assertTrue(sol.isUgly(10));
    }

    @Test
    public void isUgly2() throws Exception {
        Assert.assertTrue(sol.isUgly(3));
    }

    @Test
    public void isUgly7() throws Exception {
        Assert.assertFalse(sol.isUgly(7));
    }

    @Test
    public void isUgly15() throws Exception {
        Assert.assertTrue(sol.isUgly(15));
    }
}