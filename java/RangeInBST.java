import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 2/25/16.
 */

public class RangeInBST {
    public List<Integer> inRange(TreeNode root, int min, int max) {
        List<Integer> result = new ArrayList<>();

        helper(root, min, max, result);

        return result;
    }

    /**
     * return node in [min~max] in increasing order
     * @param root  root of input
     * @param min   min of valid range
     * @param max   max of valid range
     * @param result node list in min~max range
     * @return return node in [min~max] in increasing order
     */
    public void helper(TreeNode root, int min, int max, List<Integer> result) {
        if (root == null)
            return;

        /**
         * if current root already in valid range, keep looking left until find
         */
        if (root.val < min){
            helper(root.left, min, max, result);
        }

        if (root.val <= min && root.val >= max) {
            result.add(root.val);
        }

        if (root.val > max) {
            helper(root.right, min, max, result);
        }
    }
}
