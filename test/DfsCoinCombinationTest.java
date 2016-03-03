import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/1/16.
 */
public class DfsCoinCombinationTest {

    @Test
    public void testCoinCombination() throws Exception {
        int sum = 99;
        int[] coins = {25, 10, 5, 1};
        List<List<Integer>> rst = DfsCoinCombination.coinCombination(sum, coins);

        Iterator iter = rst.iterator();

        while(iter.hasNext()) {
            Iterator innerIter = ((List) iter.next()).iterator();
            while(innerIter.hasNext()) {
                System.out.print(innerIter.next() + " ");
            }
            System.out.println();
        }
    }
}