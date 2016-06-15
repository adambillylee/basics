import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 6/15/16.
 */
public class CountOfSmallerNumbersAfterSelfTest {
    CountOfSmallerNumbersAfterSelf sol = new CountOfSmallerNumbersAfterSelf();

    @Test
    public void countSmaller() throws Exception {
        int nums[] = {5, 2, 6, 1};
        List<Integer> expect = Arrays.asList(2, 1, 1, 0);
        List<Integer> actual = sol.countSmaller(nums);

        for (int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

}