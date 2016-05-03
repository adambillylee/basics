import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/2/16.
 */
public class ThreeSumTest {
    ThreeSum sol = new ThreeSum();

    @Test
    public void threeSum() throws Exception {
        int input[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> rst = sol.threeSum(input);

        for (List<Integer> list : rst) {
            for (int i: list)
                System.out.print(i + " ");

            System.out.println();
        }
    }

}