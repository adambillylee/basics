import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/11/16.
 */
public class MergeSortedListTest {
    MergeSortedList sol = new MergeSortedList();

    @Test
    public void merge1() throws Exception {
        int nums1[] = {1};
        int nums2[] = {};

        sol.merge(nums1, 1, nums2, 0);

        for (int ele : nums1)
            System.out.println(ele);
    }

    @Test
    public void merge2() throws Exception {
        int nums1[] = {4,0,0,0,0,0};
        int nums2[] = {1,2,3,5,6};

        sol.merge(nums1, 1, nums2, 5);

        for (int ele : nums1)
            System.out.println(ele);
    }

}