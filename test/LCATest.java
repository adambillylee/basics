import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 8/24/16.
 */
public class LCATest {
    LCA sol = new LCA();

    @Test
    public void testLowestCommonAncestor() throws Exception {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        root.left = two;
        root.right = three;

        assertEquals(root, sol.lowestCommonAncestor(root, two, three));
    }

}