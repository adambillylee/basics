import org.junit.Test;

/**
 * Created by adamli on 12/17/15.
 */
public class QuickSortTest {

    @Test
    public void testSort() throws Exception {
        int a[] = {3,4,2,1,5,6};

        for(int ele : QuickSort.sort(a))
            System.out.println(ele);
    }

    @Test
    public void test3WaySort() throws Exception {
        int a[] = {2,3,4,1,2,1,5,6,5};

        for (int ele : ThreeWayQuickSort.sort(a, 0, a.length-1))
            System.out.println(ele);
    }
}