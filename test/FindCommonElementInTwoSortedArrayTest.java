import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/8/16.
 */
public class FindCommonElementInTwoSortedArrayTest {

    @Test
    public void testFindCommon() throws Exception {
        int[] arr1 = new int[]{2,1,3,4,7,6,5};
        int[] arr2 = new int[]{2,3,4,5,6};

        ArrayList<Integer> rst = FindCommonElementInTwoSortedArray.findCommon(arr1, arr2);
        System.out.println();
    }
}