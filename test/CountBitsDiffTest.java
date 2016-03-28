import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/27/16.
 */
public class CountBitsDiffTest {

    @Test
    public void testCount1() throws Exception {
        int a = Integer.parseInt("01001110",2);
        int b = Integer.parseInt("10101010",2);

        int expected = 4;
        assertEquals(expected, CountBitsDiff.count(a, b));
    }


    @Test
    public void testCount2() throws Exception {
        int a = Integer.parseInt("00000000",2);
        int b = Integer.parseInt("11111111",2);

        int expected = 8;
        assertEquals(expected, CountBitsDiff.count(a, b));
    }


    @Test
    public void testCount3() throws Exception {
        int a = Integer.parseInt("11111111",2);
        int b = Integer.parseInt("11111111",2);

        int expected = 0;
        assertEquals(expected, CountBitsDiff.count(a, b));
    }
}