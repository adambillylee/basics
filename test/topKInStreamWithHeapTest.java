import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by adamli on 8/8/16.
 */
public class topKInStreamWithHeapTest {
    topKInStreamWithHeap sol = new topKInStreamWithHeap();

    @Test
    public void testTopK() throws Exception {
        Iterator<Integer> iterator = Arrays.asList(1,2,3,4,5).iterator();

        while (iterator.hasNext()) {
            System.out.println(sol.topK(iterator.next(), 3));
        }
    }

}