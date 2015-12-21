import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 12/15/15.
 */
public class MergeSortTest {
    @Test
    public void testMergeSortOdd() throws Exception {
        int actual[] = {2,3,5,1,6,8,0};

        MergeSort.sort(actual);

        for (int a : actual) {
            System.out.println(a);
        }

        int expected[] = {0,1,2,3,5,6,8};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMergeSortEven() throws Exception {
        int actual[] = {45,34,89,1,33,78};

        MergeSort.sort(actual);

        for (int a : actual) {
            System.out.println(a);
        }

        int expected[] = {1,33,34,45,78,89};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMergeSortBottomUp() throws Exception {
        int actual[] = {45,34,89,1,33,78};

        BottomUpMergeSort.sort(actual);

        for (int a : actual) {
            System.out.println(a);
        }

        int expected[] = {1,33,34,45,78,89};

        assertArrayEquals(expected, actual);
    }
}