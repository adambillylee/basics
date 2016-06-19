import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 6/18/16.
 */
public class MinimumHeightTreesTest {
    MinimumHeightTrees sol = new MinimumHeightTrees();

    @Test
    public void findMinHeightTrees1() throws Exception {
        int edges[][] = {
                {1, 0},
                {1, 2},
                {1, 3}
        };

        List<Integer> expected = Arrays.asList(1);
        List<Integer> rst = sol.findMinHeightTrees(4, edges);

        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(i), rst.get(i));
    }

    @Test
    public void findMinHeightTrees2() throws Exception {
        int edges[][] = {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        };

        List<Integer> expected = Arrays.asList(3, 4);
        List<Integer> rst = sol.findMinHeightTrees(6, edges);

        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(i), rst.get(i));
    }

    @Test
    public void findMinHeightTrees3() throws Exception {
        int edges[][] = {
                {0, 1}
        };

        List<Integer> expected = Arrays.asList(0,1);
        List<Integer> rst = sol.findMinHeightTrees(2, edges);

        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(i), rst.get(i));
    }

    @Test
    public void findMinHeightTrees4() throws Exception {
        int edges[][] = {
                {0, 1},
                {0, 2},
                {0, 3},
                {3, 4},
                {4, 5}
        };

        List<Integer> expected = Arrays.asList(3);
        List<Integer> rst = sol.findMinHeightTrees(6, edges);

        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(i), rst.get(i));
    }
}
