import org.junit.Test;

/**
 * Created by adamli on 12/21/15.
 */
public class HeapSortTest {
    @Test
    public void HeapSortStartWithOne() throws Exception {
        int a[] = {3,5,1,2,7,8,6,0,1};

        // test one based heap sort
        HeapSortStartWithOne.sort(a);
        System.out.println();
    }

    @Test
    public void HeapSortStartWithZero() throws Exception {
        int a[] = {3,5,1,2,7,8,6,0,1};

        // test zero based heap sort
        HeapSortStartWithZero.sort(a);
        System.out.println();
    }
}