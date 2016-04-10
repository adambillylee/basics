import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 4/9/16.
 */
public class BinaryTreePreOrderTraversalInterativeTest {
    @Test
    public void preOrderTraversal() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[] {"3", "1", "2", "4","7"});

        List<Integer> rst = BinaryTreePreOrderTraversalInterative.preOrderTraversal(root);

        for (int ele : rst) {
            System.out.println(ele);
        }
    }

}