import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by adamli on 7/21/16.
 */
public class PascalsTriangleTest {
    PascalsTriangle sol = new PascalsTriangle();

    @Test
    public void testGenerate4() throws Exception {
        List<List<Integer>> rst = sol.generate(4);

        for (List<Integer> list : rst)
            System.out.print(list.toString());
    }
    @Test
    public void testGenerate1() throws Exception {
        List<List<Integer>> rst = sol.generate(1);

        for (List<Integer> list : rst)
            System.out.print(list.toString());
    }

}