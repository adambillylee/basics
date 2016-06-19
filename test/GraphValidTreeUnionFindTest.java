import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/18/16.
 */
public class GraphValidTreeUnionFindTest {
    GraphValidTreeUnionFind sol = new GraphValidTreeUnionFind();

    @Test
    public void validTree1() throws Exception {
        int edges[][] = {
                {0,1},
                {0,2},
                {2,3},
                {2,4}
        };

        assertTrue(sol.validTree(5, edges));
    }
}