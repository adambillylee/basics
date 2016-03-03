import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by adamli on 2/29/16.
 */
public class DFS_subsetsTest {

    @Test
    public void testSubSets() throws Exception {
        int[] inputs = {1,2,3};
        List<List<Integer>> actual = DfsSubsets.subSets(inputs);

        Iterator iter = actual.iterator();

        while(iter.hasNext()) {
            Iterator innerIter = ((List) iter.next()).iterator();
            System.out.print("[");
            while(innerIter.hasNext()) {
                System.out.print(innerIter.next());
            }
            System.out.println("]");
        }
    }
}