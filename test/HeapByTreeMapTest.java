import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/21/16.
 */
public class HeapByTreeMapTest {
    HeapByTreeMap sol = new HeapByTreeMap();

    @Test
    public void heapByTreeMap() throws Exception {
        int input[] = {4,5,3,1,2};
        sol.heap(input);
        System.out.println();
    }

    @Test
    public void heapByPQ() throws Exception {
        int input[] = {4,5,3,1,2};
        sol.heapByPQ(input);
        System.out.println();
    }

}