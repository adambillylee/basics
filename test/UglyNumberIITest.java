import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/12/16.
 */
public class UglyNumberIITest {
    UglyNumberII sol = new UglyNumberII();

    @Test
    public void nthUglyNumber() throws Exception {
        assertEquals(12, sol.nthUglyNumber(10));
    }

}