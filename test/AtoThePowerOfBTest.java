import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/15/16.
 */
public class AtoThePowerOfBTest {

    @Test
    public void testA_pow_b() throws Exception {
        int a = 2;
        int b = 5;

        int actual = AtoThePowerOfB.a_pow_b(a, b);
        int expected = 32;

        assertEquals(expected, actual);
    }

    @Test
    public void testA_pow_b2() throws Exception {
        int a = 4;
        int b = 3;

        int actual = AtoThePowerOfB.a_pow_b(a, b);
        int expected = (int)Math.pow(4, 3);

        assertEquals(expected, actual);
    }
}