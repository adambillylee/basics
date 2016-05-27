import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/26/16.
 */
public class CountingBitsTest {
    CountingBits sol = new CountingBits();

    @Test
    public void countBits16() throws Exception {
        sol.countBits(16);
    }


    @Test
    public void countBits2() throws Exception {
        sol.countBits(2);
    }
}