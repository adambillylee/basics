import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adamli on 2/11/16.
 */
public class QuickSortTest {

    @Test
    public void testQuickSort() throws Exception {
        int[] actual = new int[]{1, 9, 8, 3, 5};

        QuickSort.QuickSort(actual);

        for (int i:actual)
            System.out.print(i + " ");

        int[] expected = {1,3,5,8,9};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuickSort2() throws Exception {
        int[] actual = new int[]{1, 9, 8, 3, 5, 2};

        QuickSort.QuickSort(actual);

        for (int i:actual)
            System.out.print(i + " ");

        int[] expected = {1,2,3,5,8,9};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuickSortWithDups() throws Exception {
        int[] actual = new int[]{1, 3, 8, 3, 5, 2};

        QuickSort.QuickSort(actual);

        for (int i:actual)
            System.out.print(i + " ");

        int[] expected = {1,2,3,3,5,8};

        Assert.assertArrayEquals(expected, actual);
    }
}