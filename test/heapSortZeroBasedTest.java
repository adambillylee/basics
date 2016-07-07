import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 7/6/16.
 */
public class heapSortZeroBasedTest {
    heapSortZeroBased sol = new heapSortZeroBased();

    @Test
    public void testHeapSortEven() throws Exception {
        int actual[] = sol.heapSort(new int[]{3, 5, 1, 2, 4});

        Assert.assertArrayEquals(actual, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testHeapSortOdd() throws Exception {
        int actual[] = sol.heapSort(new int[]{3, 5, 6, 1, 2, 4});

        Assert.assertArrayEquals(actual, new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testHeapSortOne() throws Exception {
        int actual[] = sol.heapSort(new int[]{1});

        Assert.assertArrayEquals(actual, new int[]{1});
    }

    @Test
    public void testHeapSortTwo() throws Exception {
        int actual[] = sol.heapSort(new int[]{2, 1});

        Assert.assertArrayEquals(actual, new int[]{1, 2});
    }
}