import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/29/16.
 */
public class JumpGameTest {
    @Test
    public void testDPReverseTrue() {
        int input[] = {2,3,1,1,4};
        assertTrue(JumpGame.jumpDPReverse(input));
    }

    @Test
    public void testDPReverseFalse() {
        int input[] = {3,2,1,0,4};
        assertFalse(JumpGame.jumpDPReverse(input));
    }
    @Test
    public void testDPTrue() {
        int input[] = {2,3,1,1,4};
        assertTrue(JumpGame.jumpDP(input));
    }

    @Test
    public void testDPFalse() {
        int input[] = {3,2,1,0,4};
        assertFalse(JumpGame.jumpDP(input));
    }

    @Test
    public void testMaxReachTrue() {
        int input[] = {2,3,1,1,4};
        assertTrue(JumpGame.jumpMaxReach(input));
    }

    @Test
    public void testMaxReachFalse() {
        int input[] = {3,2,1,0,4};
        assertFalse(JumpGame.jumpMaxReach(input));
    }
}