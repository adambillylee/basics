import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 12/10/15.
 */
public class isPermutationOfTest {
    isPermutationOf sol = new isPermutationOf();

    @Test
    public void testIsPermutationOfTrue() throws Exception {
        String a = "abcd";
        String b = "dcba";

        assertTrue("True case by sort failed", sol.isPermutationOfBySort(a, b));
        assertTrue("True case by count failed", sol.isPermutationOfByCount(a, b));
    }

    @Test
    public void testIsPermutationOfFalse() throws Exception {
        String a = "abcd";
        String b = "daba";

        assertFalse("False case by sort failed", sol.isPermutationOfBySort(a, b));
        assertFalse("False case by count failed", sol.isPermutationOfByCount(a, b));
    }
}