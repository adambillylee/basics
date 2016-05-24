import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/23/16.
 */
public class BinaryTreeVerticalOrderTraversalNoHashTableTest {
    BinaryTreeVerticalOrderTraversalNoHashTable sol = new BinaryTreeVerticalOrderTraversalNoHashTable();

    @Test
    public void verticalOrder() throws Exception {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        List<List<Integer>> rst = sol.verticalOrder(one);

        for (List<Integer> list : rst) {
            for (int ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

}