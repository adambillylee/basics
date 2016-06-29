import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 6/28/16.
 */
public class SolutionTest {
    Solution sol = new Solution();

    @Test
    public void testSerialize() throws Exception {
        sol.serialize(null);
    }

}