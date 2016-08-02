/**
 * Created by adamli on 2/25/16.
 */
public class TweakedIdenticalBinaryTree {
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a == null && b!= null)
            return false;

        if (a != null && b == null)
            return false;

        if (a.val != b.val)
            return false;

        // check if already identical
        boolean notTwistedLeft = isTweakedIdentical(a.left, b.left);
        boolean notTwistedRight = isTweakedIdentical(a.right, b.right);

        if ((notTwistedLeft && notTwistedRight) == true)
            return true;

        // check if identical twisted
        boolean twistedLeft = isTweakedIdentical(a.left, b.right);
        boolean twistedRight = isTweakedIdentical(a.right, b.left);

        if ((twistedLeft && twistedRight) == true)
            return true;


        return false;
    }
}
