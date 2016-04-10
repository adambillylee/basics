import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/10/16.
 */
public class BinaryTreePostorderTraversalTest {
    @Test
    public void postorderTraversalTwoStack() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[] {"3", "1", "2", "4","7"});

        List<Integer> rst = BinaryTreePostorderTraversal.postorderTraversalTwoStack(root);

        for (int ele : rst) {
            System.out.println(ele);
        }
    }

}