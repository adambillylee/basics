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
        assertFalse(ValidateBST.validateInorder(root));
    }

    @Test
    public void validate2() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"2147483647"});
        assertTrue(ValidateBST.validateRecurr(root));
        assertTrue(ValidateBST.validateInorder(root));
    }

}