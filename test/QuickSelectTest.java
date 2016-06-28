import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 6/27/16.
 */
public class QuickSelectTest {
    QuickSelect sol = new QuickSelect();

    @Test
    public void testSelect() {
        int[] test = new int[]{7, 9, 2, 3, 5, 1, 4};
        List<Integer> a = new ArrayList<>();

        // left boundary
        Assert.assertEquals(sol.quickSelect(test, 1), 1);

        // right boundary
        Assert.assertEquals(sol.quickSelect(test, 7), 9);

        // random number
        Assert.assertEquals(sol.quickSelect(test, 3), 3);
    }

}