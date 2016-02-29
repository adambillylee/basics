import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by adamli on 12/3/15.
 */
public class TreeUtil {
    public static TreeNode getRoot(String[] array) {
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<array.length; i++)
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

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode curr = queue.poll();

            for(int i=0; i<size; i++) {
                if (index == list.size())
                    break;


                // create left and right node
                TreeNode left = setNode(list, index++);

                if (left != null)
                    queue.offer(left);

                TreeNode right = setNode(list, index++);

                if (right != null)
                    queue.offer(right);

                // attach left and right node to curr (if its not empty)
                if (curr != null) {
                    curr.left = left;
                    curr.right = right;
                }
            }
        }

        return root;
    }

    public static TreeNode setNode(ArrayList<String> list, int index) {
        String val = list.get(index);

        if (val.equals(""))
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

        int count = 1;
        while(count > 0) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                list.add("");
                queue.offer(null);
                queue.offer(null);
                continue;
            } else {
                list.add(String.valueOf(curr.val));
                count--;
            }

            if (curr.left != null)
                count++;

            if(curr.right != null)
                count++;

            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        for (String ele : list)
            System.out.print(ele + ",");

        return list.toArray(new String[list.size()]);
    }
}
