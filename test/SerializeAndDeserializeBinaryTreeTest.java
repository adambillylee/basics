import org.junit.Test;

/**
 * Created by adamli on 4/27/16.
 */
public class SerializeAndDeserializeBinaryTreeTest {
    SerializeAndDeserializeBinaryTree sol = new SerializeAndDeserializeBinaryTree();

    @Test
    public void serialize1() throws Exception {
        // build tree
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two;
        root.right = three;
        two.right = four;
        three.right = five;

        String codec = sol.serialize(root);

        System.out.println(codec);

        TreeNode deSerialized = sol.deserialize(codec);

        System.out.println();
    }

    @Test
    public void serialize2() throws Exception {
        // build tree
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two;
        root.right = three;
        three.left = four;
        four.right = five;

        String codec = sol.serialize(root);

        System.out.println(codec);


    }

    @Test
    public void serialize3() throws Exception {
        // build tree
        TreeNode root = new TreeNode(-1);
        TreeNode zero = new TreeNode(0);
        TreeNode one = new TreeNode(1);


        root.left = zero;
        root.right = one;

        TreeNode actual = sol.deserialize(sol.serialize(root));
        System.out.println();
    }

}