/**
 * Created by adamli on 8/27/16.
 */
public class SeralizeAndDeseralizeNaryTree {
    int index = 0;

    String serialize(NaryTreeNode root) {
        if (root == null)
            return "#";

        String s = "" + root.val;

        for (int i = 0; i < 3; i++) {
            s += serialize(root.next[i]);
        }

        return s;
    }

    NaryTreeNode deSeralize(String codex) {
        NaryTreeNode rst = null;

        if (codex.charAt(index) == '#') {
            index++;
            return rst;
        } else {
            rst = new NaryTreeNode(Integer.parseInt(codex.substring(index, index + 1)));
            index++;
        }

        for (int i=0; i<3; i++) {
            rst.next[i] = deSeralize(codex);
        }


        return rst;
    }
}
