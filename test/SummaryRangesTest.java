import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by adamli on 6/29/16.
 */
public class SummaryRangesTest {
    SummaryRanges sol = new SummaryRanges();

    @Test
    public void testSummaryRanges() throws Exception {
        int nums[] = {0,1,2,4,5,7};
        List<String> rst = sol.summaryRanges(nums);

        System.out.println(rst.toString());
    }

}