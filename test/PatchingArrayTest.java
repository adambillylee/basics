import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/29/16.
 */
public class PatchingArrayTest {
    @Test
    public void minPatches() throws Exception {
        int nums[] = {1,2,4,13,43};
        int n = 100;
        assertEquals(2, PatchingArray.minPatches(nums, n));

        /**
         |  n |             list | maxBuild | patches |
         |---:|-----------------:|---------:|--------:|
         |  0 |                  |        0 |       0 |
         |  1 |                1 |        1 |       0 |
         |  2 |              1,2 |        3 |       0 |
         |  4 |            1,2,4 |        7 |       0 |
         |  8 |          1,2,4,8 |       15 |       1 |
         | 16 |       1,2,4,8,13 |       28 |       1 |
         | 29 |    1,2,4,8,13,29 |       57 |       2 |
         | 58 | 1,2,3,8,13,29,43 |      101 |       2 |
         */
    }

}