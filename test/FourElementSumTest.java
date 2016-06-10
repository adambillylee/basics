import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by adamli on 6/10/16.
 */
public class FourElementSumTest {
    FourElementSum sol = new FourElementSum();

    @Test
    public void findPairs1() throws Exception {
        int num[] = {1, 4, 2, 3};
        assertTrue(sol.findPairs(num));
    }

    @Test
    public void findPairs2() throws Exception {
        int num[] = {3,4,7,1,2,9,8};
        assertTrue(sol.findPairs(num));
    }

    @Test
    public void findPairs3() throws Exception {
        int num[] = {1,3,1,1};
        assertFalse(sol.findPairs(num));
    }

    @Test
    public void findPairs4() throws Exception {
        int num[] = {1,1,1,1};
        assertTrue(sol.findPairs(num));
    }

}