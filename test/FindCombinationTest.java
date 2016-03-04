import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/2/16.
 */
public class FindCombinationTest {

    @Test
    public void testFindCombination() throws Exception {
        int total = 99;
        int[] coins = new int[]{25,10,5,1};

        ArrayList<int[]> rst = FindCombination.main(total, coins);
    }
}