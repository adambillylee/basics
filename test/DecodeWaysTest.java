import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/19/16.
 */
public class DecodeWaysTest {
    DecodeWays sol = new DecodeWays();

    @Test
    public void numDecodings1() throws Exception {
        String s = "1";
        assertEquals(1, sol.numDecodings(s));
    }

    @Test
    public void numDecodings2() throws Exception {
        String s = "123";
        assertEquals(3, sol.numDecodings(s));
    }

    @Test
    public void numDecodings3() throws Exception {
        String s = "127";
        assertEquals(2, sol.numDecodings(s));
    }

}