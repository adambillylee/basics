import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adamli on 6/14/16.
 */
public class InOrderSuccessorOfBSTRecursiveTest {
    InOrderSuccessorOfBSTRecursive sol = new InOrderSuccessorOfBSTRecursive();

    @Test
    public void inorderSuccessor15() throws Exception {
        TreeNode root = new TreeNode(20);
        TreeNode ten = new TreeNode(10);
        TreeNode zero = new TreeNode(0);
        TreeNode fifteen = new TreeNode(15);
        TreeNode thirty = new TreeNode(30);
        TreeNode twentyFive = new TreeNode(25);
        TreeNode thirtyFive = new TreeNode(35);

        root.left = ten;
        root.right = thirty;
        ten.left = zero;
        ten.right = fifteen;
        thirty.left = twentyFive;
        thirty.right = thirtyFive;

        Assert.assertEquals(20, sol.inorderSuccessor(root, fifteen).val);
    }

    @Test
    public void inorderSuccessor25() throws Exception {
        TreeNode root = new TreeNode(20);
        TreeNode ten = new TreeNode(10);
        TreeNode zero = new TreeNode(0);
        TreeNode fifteen = new TreeNode(15);
        TreeNode thirty = new TreeNode(30);
        TreeNode twentyFive = new TreeNode(25);
        TreeNode thirtyFive = new TreeNode(35);

        root.left = ten;
        root.right = thirty;
        ten.left = zero;
        ten.right = fifteen;
        thirty.left = twentyFive;
        thirty.right = thirtyFive;

        Assert.assertEquals(30, sol.inorderSuccessor(root, twentyFive).val);
    }

    @Test
    public void inorderSuccessor20() throws Exception {
        TreeNode root = new TreeNode(20);
        TreeNode ten = new TreeNode(10);
        TreeNode zero = new TreeNode(0);
        TreeNode fifteen = new TreeNode(15);
        TreeNode thirty = new TreeNode(30);
        TreeNode twentyFive = new TreeNode(25);
        TreeNode thirtyFive = new TreeNode(35);

        root.left = ten;
        root.right = thirty;
        ten.left = zero;
        ten.right = fifteen;
        thirty.left = twentyFive;
        thirty.right = thirtyFive;

        Assert.assertEquals(25, sol.inorderSuccessor(root, root).val);
    }

    @Test
    public void inorderSuccessor30() throws Exception {
        TreeNode root = new TreeNode(20);
        TreeNode ten = new TreeNode(10);
        TreeNode zero = new TreeNode(0);
        TreeNode fifteen = new TreeNode(15);
        TreeNode thirty = new TreeNode(30);
        TreeNode twentyFive = new TreeNode(25);
        TreeNode thirtyFive = new TreeNode(35);

        root.left = ten;
        root.right = thirty;
        ten.left = zero;
        ten.right = fifteen;
        thirty.left = twentyFive;
        thirty.right = thirtyFive;

        Assert.assertEquals(35, sol.inorderSuccessor(root, thirty).val);
    }

    @Test
    public void inorderSuccessor2() throws Exception {
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = eight;
        two.left = zero;
        two.right = four;
        four.left = three;
        four.right = five;
        eight.left = seven;
        eight.right = nine;

        Assert.assertEquals(3, sol.inorderSuccessor(root, two).val);
    }

    @Test
    public void inorderSuccessor6() throws Exception {
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = eight;
        two.left = zero;
        two.right = four;
        four.left = three;
        four.right = five;
        eight.left = seven;
        eight.right = nine;

        Assert.assertEquals(7, sol.inorderSuccessor(root, root).val);
    }

    @Test
    public void inorderSuccessor3() throws Exception {
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = eight;
        two.left = zero;
        two.right = four;
        four.left = three;
        four.right = five;
        eight.left = seven;
        eight.right = nine;

        Assert.assertEquals(4, sol.inorderSuccessor(root, three).val);
    }

}