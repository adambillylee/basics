import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/18/16.
 */
public class GraphValidTreeBFSTest {
    GraphValidTreeBFS sol = new GraphValidTreeBFS();

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

    @Test
    public void validTree2() throws Exception {
        int edges[][] = {
                {0,1},
                {0,2}
        };

        assertTrue(sol.validTree(3, edges));
    }

    @Test
    public void validTree3() throws Exception {
        int edges[][] = {
                {0,1},
                {0,2},
                {1,2},
                {2,3},
                {2,4}
        };

        assertFalse(sol.validTree(5, edges));
    }
    @Test
    public void validTree4() throws Exception {
        int edges[][] = {
                {0,1},
                {2,3}
        };

        assertFalse(sol.validTree(4, edges));
    }
}