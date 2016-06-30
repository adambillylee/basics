import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 6/30/16.
 */
public class ValidRomanTest {
    ValidRoman sol = new ValidRoman();

    @Test
    public void testIsPowerOfTen() throws Exception {
        assertTrue(sol.isPowerOfTen(100));
        assertFalse(sol.isPowerOfTen(20));
        assertTrue(sol.isPowerOfTen(1));
    }

    @Test
    public void isValidRoman20() throws Exception {
        assertTrue(sol.isValidRoman("XX"));
    }

    @Test
    public void isValidRoman15() throws Exception {
        assertTrue(sol.isValidRoman("XV"));
    }

    @Test
    public void isValidRoman44() throws Exception {
        assertTrue(sol.isValidRoman("XLIV"));
    }

    @Test
    public void isValidRoman769() throws Exception {
        assertTrue(sol.isValidRoman("DCCLXIX"));
    }

    @Test
    public void isValidRomanFalse1() throws Exception {
        assertFalse(sol.isValidRoman("DCICLXIX"));
    }


    @Test
    public void isValidRomanFalse2() throws Exception {
        assertFalse(sol.isValidRoman("DCCALXIX"));
    }

}