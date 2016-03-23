import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/23/16.
 */
public class isPowerOf2Test {

    @Test
    public void isPowerOf2False() throws Exception {
        int input = 100;
        assertFalse(isPowerOf2.isPowerOf2(input));
    }

    @Test
    public void isPowerOf2True() throws Exception {
        int input = 64;
        assertTrue(isPowerOf2.isPowerOf2(input));
    }
}