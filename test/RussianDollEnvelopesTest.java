import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/23/16.
 */
public class RussianDollEnvelopesTest {
    RussianDollEnvelopes sol = new RussianDollEnvelopes();

    @Test
    public void maxEnvelopes1() throws Exception {
        int envelops[][] = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };

        assertEquals(3, sol.maxEnvelopes(envelops));
    }

    @Test
    public void maxEnvelopes2() throws Exception {
        int envelops[][] = {
                {30,50},
                {12,2},
                {3,4},
                {12,15}
        };

        assertEquals(3, sol.maxEnvelopes(envelops));
    }
}