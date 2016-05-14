import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 5/14/16.
 */
public class TopKFrequentElementsTest {
    TopKFrequentElements sol = new TopKFrequentElements();

    @Test
    public void topKFrequent() throws Exception {
        int nums[] = {1, 1, 2, 2, 3, 3, 4, 5, 6, 1};
        int k = 3;

        List<Integer> rst = sol.topKFrequent(nums, k);

        for (int ele : rst)
            System.out.println(ele);
    }

}