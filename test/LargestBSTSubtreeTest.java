import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/21/16.
 */
public class LargestBSTSubtreeTest {

    LargestBSTSubtree sol = new LargestBSTSubtree();

    @Test
    public void largestBSTSubtree() throws Exception {
        TreeNode root = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(55);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);

        root.left = five;
        root.right = fifteen;
        five.left = one;
        five.right = eight;
        fifteen.right = seven;

        assertEquals(3, sol.largestBSTSubtree(root));
    }

}