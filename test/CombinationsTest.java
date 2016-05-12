import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 5/10/16.
 */
public class CombinationsTest {
    Combinations sol = new Combinations();

    @Test
    public void combine() throws Exception {
        int n = 4;
        int k = 2;
        List<List<Integer>> rst = sol.combine(n, k);

        for (List<Integer> list : rst) {
            for (int ele : list) {
                System.out.print(ele + " ");
            }

            System.out.println();
        }

    }

}