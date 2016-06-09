import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 6/8/16.
 */
public class BinaryTreeToInOrderDoubleLinkedListRecursiveTest {
    BinaryTreeToInOrderDoubleLinkedListRecursive sol = new BinaryTreeToInOrderDoubleLinkedListRecursive();

    @Test
    public void convert() throws Exception {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        two.left = four;
        three.right = five;

        BinaryTreeToInOrderDoubleLinkedListRecursive.DLinkedNode rst = sol.convertInOrder(one);

        assertEquals(1, rst.val);
        rst = rst.left;
        assertEquals(2, rst.val);
        rst = rst.left;
        assertEquals(4, rst.val);
        rst = rst.right;
        assertEquals(2, rst.val);
        rst = rst.right;
        assertEquals(1, rst.val);
        rst = rst.right;
        assertEquals(3, rst.val);
        rst = rst.right;
        assertEquals(5, rst.val);
    }

}