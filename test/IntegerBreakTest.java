import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/22/16.
 */
public class IntegerBreakTest {
    private class testNode{
        testNode[] next = new testNode[26];
    }
    @Test
    public void integerBreak() throws Exception {
        assertEquals(12, IntegerBreak.integerBreak(7));

    }
}