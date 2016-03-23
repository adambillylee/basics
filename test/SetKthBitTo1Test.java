import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/23/16.
 */
public class SetKthBitTo1Test {

    @Test
    public void set() throws Exception {
        int input = Integer.parseInt("10000000", 2);
        int k = 3;

        int actual = SetKthBitTo1.set(input, k);
        int expected = Integer.parseInt("10000100", 2);
        assertEquals(expected, actual);
    }
}