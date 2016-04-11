import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/11/16.
 */
public class NimGameTest {
    @Test
    public void canWinNim() throws Exception {
        int[] input = {4,5,6,7,8,9};
        boolean[] expected = {false, true,true, true, false, true};

        for (int i=0; i<input.length; i++) {
            assertEquals(NimGame.dp(input[i]), expected[i]);
        }
    }

}