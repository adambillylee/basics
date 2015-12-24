import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 12/23/15.
 */
public class MinPQStartWithZeroTest {
    MinPQStartWithZero sol = new MinPQStartWithZero(6);

    @Test
    // correct sequence: 2,3,1,5,6,11
    public void testPQ() throws Exception {
        sol.insert(3);
        sol.insert(2);
        sol.insert(5);

        // 2,3,5, pop 2
        sol.delMin();

        sol.insert(11);
        sol.insert(6);

        // 2,3,5,6,11, pop 2
        sol.delMin();

        sol.insert(1);

        // 1,3,5,6,11
        sol.delMin();
        sol.delMin();
        sol.delMin();
        sol.delMin();
    }
}