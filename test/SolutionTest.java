import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 7/31/16.
 */
public class SolutionTest {
    Solution sol = new Solution();

    @Test
    public void testGetKeditDistance() throws Exception {
        String target = "a";
        String words[] = {"abc"};

        sol.getKeditDistance(words, target, 2);
    }

}