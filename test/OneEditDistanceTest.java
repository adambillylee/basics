import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/10/16.
 */
public class OneEditDistanceTest {
    OneEditDistance sol = new OneEditDistance();

    @Test
    public void isOneEditDistance() throws Exception {
        String a = "a";
        String b = "aa";
        assertTrue(sol.isOneEditDistance(a, b));
    }

}