import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/23/16.
 */
public class isBalancedTreeTest {

    @Test
    public void testIsNotBalanced() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]
                {"1","2","3","4","","","","6","7"});

        boolean expected = false;
        boolean actual = isBalancedTree.isBalanced(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testIsBalanced() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]
                {"1","2","3","4","5","6","7","8","9"});

        boolean expected = true;
        boolean actual = isBalancedTree.isBalanced(root);

        assertEquals(expected, actual);
    }
}