import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by adamli on 12/3/15.
 */
public class TreeUtil {
    public static TreeNode getRoot(String[] array) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
            list.add(array[i]);

        return getRoot(list);
    }

    public static TreeNode getRoot(ArrayList<String> list) {
        TreeNode root = null;

        // sanity check
        if (list.size() == 0)
            return root;

        // create root node and add it into queue
        int index = 0;
        root = new TreeNode(Integer.valueOf(list.get(index++)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                /**
                 * because this queue will have empty treeNodes
                 * we must stop when list index reaches the end
                 */
                if (index == list.size())
                    break;

                // create left and right node
                TreeNode left = setNode(list, index++);

                /**
                 * it is possible to add null into queue
                 * since we need to add empty treeNode to maintain tree structure
                 */
                if (left != null) {
                    queue.offer(left);
                }

                TreeNode right = setNode(list, index++);

                if (right != null)
                    queue.offer(right);

                /**
                 * only attach left / right to root when root is not null
                 */
                if (curr != null) {
                    curr.left = left;
                    curr.right = right;
                }

                if (left == null && right != null) {
                    list.add(index, "");
                    list.add(index, "");
                    index += 2;
                }
            }
        }

        return root;
    }

    /**
     * return treeNode with value or null
     *
     * @param list  incoming arraylist
     * @param index index of array list
     * @return TreeNode or null
     */
    public static TreeNode setNode(ArrayList<String> list, int index) {
        if (index >= list.size())
            return null;

        String val = list.get(index);

        if (val.equals("") || val.equals("#"))
            return null;
        else
            return new TreeNode(Integer.valueOf(val));
    }

    public static String[] printTree(TreeNode root) {
        if (root == null)
            System.out.println("Empty tree");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<String> list = new ArrayList<>();

        /**
         * transformed BFS
         * since we need to press null treeNode as well, we need to add null nodes into queue
         * as a result, we cannot simply use queue size to determine the end of BFS
         * use counter to track non null node count in queue, stop when all nodes in queue is null
         */
        int nonNullNodesInQueue = 1;
        while (nonNullNodesInQueue > 0) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                list.add("");

                /**
                 * add two null treeNodes into queue for left and right and skip current loop
                 * to avoid NullPointer in curr.left later
                 */
                queue.offer(null);
                queue.offer(null);
                continue;
            } else {
                /**
                 * when a non null node poped from queue, reduce counter by 1
                 */
                list.add(String.valueOf(curr.val));
                nonNullNodesInQueue--;
            }

            // update counter when current node is not null
            if (curr.left != null)
                nonNullNodesInQueue++;

            if (curr.right != null)
                nonNullNodesInQueue++;

            // add left and right when current node is not null
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        for (String ele : list)
            System.out.print(ele + ",");

        return list.toArray(new String[list.size()]);
    }
}
