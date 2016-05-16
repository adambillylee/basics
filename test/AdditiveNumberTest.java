import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by adamli on 5/15/16.
 */
public class AdditiveNumberTest {
    AdditiveNumber sol = new AdditiveNumber();

    @Test
    public void isAdditiveNumber1() throws Exception {
        String num = "199100199";
        assertTrue(sol.isAdditiveNumber(num));
    }

    @Test
    public void isAdditiveNumber2() throws Exception {
        String num = "112358";
        assertTrue(sol.isAdditiveNumber(num));
    }

    @Test
    public void isAdditiveNumber3() throws Exception {
        String num = "358";
        assertTrue(sol.isAdditiveNumber(num));
    }

    @Test
    public void isAdditiveNumber4() throws Exception {
        String num = "12122436";
        assertTrue(sol.isAdditiveNumber(num));
    }

}