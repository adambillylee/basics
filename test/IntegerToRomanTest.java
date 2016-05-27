import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/26/16.
 */
public class IntegerToRomanTest {
    IntegerToRoman sol = new IntegerToRoman();

    @Test
    public void intToRoman1() throws Exception {
        int input = 36;
        assertEquals("XXXVI", sol.intToRoman(input));
    }

    @Test
    public void intToRoman2() throws Exception {
        int input = 1996;
        assertEquals("MCMXCVI", sol.intToRoman(input));
    }
}