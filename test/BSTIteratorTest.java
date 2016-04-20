import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/19/16.
 */
public class BSTIteratorTest {
    TreeNode root;

    @Before
    public void setup() {
        root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        root.right = two;
    }

    @Test
    public void iterateBST() throws Exception {
        BSTIterator sol = new BSTIterator(root);

        while(sol.hasNext()) {
            System.out.println(sol.next());
        }
    }
}