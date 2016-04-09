import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/9/16.
 */
public class ValidateBSTTest {
    @Test
    public void validate1() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"1","2","3"});
        assertFalse(ValidateBST.validate(root));
    }

    @Test
    public void validate2() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"2147483647"});
        assertTrue(ValidateBST.validate(root));
    }

}