import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/23/16.
 */
public class PreOrderTraverseTest {

    @Test
    public void testPreOrder() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"1","2","3","4","5"});
        PreOrderTraverse.preOrder(root);
    }
}