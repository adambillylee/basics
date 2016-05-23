import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by adamli on 5/23/16.
 */
public class IntersectionOfTwoArraysTest {
    IntersectionOfTwoArrays sol = new IntersectionOfTwoArrays();

    @Test
    public void intersection() throws Exception {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        assertArrayEquals(new int[]{2}, sol.intersection(nums1, nums2));
    }

}