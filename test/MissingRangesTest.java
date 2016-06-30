import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by adamli on 6/29/16.
 */
public class MissingRangesTest {
    MissingRanges sol = new MissingRanges();

    @Test
    public void testFindMissingRanges() throws Exception {
        int[] nums = {0, 1, 3, 50, 75};
        List<String> rst = sol.findMissingRanges(nums, 0, 99);

        System.out.println(rst.toString());
    }

}