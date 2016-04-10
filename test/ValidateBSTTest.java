import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by adamli on 4/9/16.
 */
public class ValidateBSTTest {
    @Test
    public void validate1() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"1", "2", "3"});
        assertFalse(ValidateBST.validateRecurr(root));

        assertFalse(new ValidateBST().validateInorder(root));
    }

    @Test
    public void validate2() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"2147483647"});
        assertTrue(ValidateBST.validateRecurr(root));
        assertTrue(new ValidateBST().validateInorder(root));
    }

    @Test
    public void validate3() throws Exception {
        TreeNode root = new TreeNode(0);
        TreeNode minusOne = new TreeNode(-1);
        root.left = minusOne;

        assertTrue(ValidateBST.validateRecurr(root));
        assertTrue(new ValidateBST().validateInorder(root));
    }

}