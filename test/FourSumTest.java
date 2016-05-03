import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 5/2/16.
 */
public class FourSumTest {
    FourSum sol = new FourSum();

    @Test
    public void fourSum1() throws Exception {
        int input[] = {1, 0, -1, 0, -2, 2};

        List<List<Integer>> rst = sol.fourSum(input, 0);

        for (List<Integer> list : rst) {
            for (int i: list)
                System.out.print(i + " ");

            System.out.println();
        }
    }

    @Test
    public void fourSum2() throws Exception {
        int input[] = {0,0,0,0};

        List<List<Integer>> rst = sol.fourSum(input, 0);

        for (List<Integer> list : rst) {
            for (int i: list)
                System.out.print(i + " ");

            System.out.println();
        }
    }

}