import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 3/29/16.
 */
public class JumpGameIITest {

    @Test
    public void jump() throws Exception {
        int input[] = {2,3,1,1,4};
        assertEquals(2, JumpGameII.jumpDP(input));
    }

    @Test
    public void jump2() throws Exception {
        int input[] = {2,4,3,1,1,3,1};
        assertEquals(3, JumpGameII.jumpDP(input));
    }

    @Test
    public void jumpReverse() throws Exception {
        int input[] = {2,3,1,1,4};
        assertEquals(2, JumpGameII.jumpDPReverse(input));
    }

    @Test
    public void jumpReverse2() throws Exception {
        int input[] = {2,4,3,1,1,3,1};
        assertEquals(3, JumpGameII.jumpDPReverse(input));
    }
}