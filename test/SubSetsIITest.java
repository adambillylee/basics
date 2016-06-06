import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/5/16.
 */
public class SubSetsIITest {
    SubSetsII sol = new SubSetsII();

    @Test
    public void subsetsWithDup() throws Exception {
        List<List<Integer>> rst = sol.subsetsWithDup(new int[]{1,2,2,3});

        for (List<Integer> list : rst) {
            for (int tmp : list) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
    }

}