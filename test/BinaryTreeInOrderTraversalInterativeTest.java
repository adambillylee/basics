import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 4/9/16.
 */
public class BinaryTreeInOrderTraversalInterativeTest {
    @Test
    public void inorderTraversal() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"2", "1", "3", "5", "6", "7", "8"});

        List<Integer> rst = BinaryTreeInOrderTraversalInterative.inOrderTraversal(root);

        for (Integer ele :rst) {
            System.out.println(ele);
        }
    }

}