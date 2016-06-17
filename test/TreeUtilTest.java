import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 2/28/16.
 */
public class TreeUtilTest {

    @Test
    public void testGetRoot() throws Exception {
        String[] actual = {"1", "2", "", "3", "4"};
        TreeNode root = TreeUtil.getRoot(actual);

        assertArrayEquals(TreeUtil.printTree(root), actual);
    }

    @Test
    public void testSetNode() throws Exception {
        TreeNode expected = new TreeNode(1);

        ArrayList<String> actualList = new ArrayList<>();
        actualList.add("1");

        TreeNode actual = TreeUtil.setNode(actualList, 0);

        assertEquals(expected.val, actual.val);

        expected = null;

        actualList = new ArrayList<>();
        actualList.add("");

        actual = TreeUtil.setNode(actualList, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTree() throws Exception {
        TreeNode root = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = one;
        root.right = null;
        one.left = two;
        one.right = three;
        two.left = null;
        two.right = four;
        three.right = five;

        String[] expected = {"0", "1", "", "2", "3", "", "", "", "4", "", "5"};

        String[] actual = TreeUtil.printTree(root);

        assertArrayEquals(expected, actual);

        root.print();
    }

    @Test
    public void testGetRoot2() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"5","4","7","3","","2","","-1","","9"});
        root.print();
    }
}