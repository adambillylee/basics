import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/29/16.
 */
public class JumpGameTest {
    @Test
    public void testJumpTrue() {
        int input[] = {2,3,1,1,4};
        assertTrue(JumpGame.jump(input));
    }

    @Test
    public void testJumpFalse() {
        int input[] = {3,2,1,0,4};
        assertFalse(JumpGame.jump(input));
    }
}