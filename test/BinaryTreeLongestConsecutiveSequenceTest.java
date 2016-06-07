import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/6/16.
 */
public class BinaryTreeLongestConsecutiveSequenceTest {
    BinaryTreeLongestConsecutiveSequence sol = new BinaryTreeLongestConsecutiveSequence();

    @Test
    public void longestConsecutive1() throws Exception {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.right = three;
        three.left = two;
        three.right = four;
        four.right = five;

        assertEquals(3, sol.longestConsecutive(one));
    }

    @Test
    public void longestConsecutive2() throws Exception {
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(1);

        one.right = two;
        two.left = three;
        three.left = four;

        assertEquals(2, sol.longestConsecutive(one));
    }

    @Test
    public void longestConsecutive3() throws Exception {
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(4);
        TreeNode four = new TreeNode(3);

        one.right = two;
        one.left = three;
        two.left = four;

        assertEquals(2, sol.longestConsecutive(one));
    }

}