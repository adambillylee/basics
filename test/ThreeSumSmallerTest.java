import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/3/16.
 */
public class ThreeSumSmallerTest {
    @Test
    public void threeSumSmaller() throws Exception {
        int nums[] = {-2, 0, 1, 3};
        int k = 2;

        assertEquals(2, ThreeSumSmaller.threeSumSmaller(nums, k));
    }

}