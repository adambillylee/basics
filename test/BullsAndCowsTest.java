import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/30/16.
 */
public class BullsAndCowsTest {
    BullsAndCows sol = new BullsAndCows();

    @Test
    public void getHint1() throws Exception {
        String secret = "1123";
        String guess = "0111";

        assertEquals("1A1B", sol.getHint(secret, guess));
    }

    @Test
    public void getHint2() throws Exception {
        String secret = "1122";
        String guess = "1222";

        assertEquals("3A0B", sol.getHint(secret, guess));
    }

}