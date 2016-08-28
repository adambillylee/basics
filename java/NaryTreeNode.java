import java.util.List;

/**
 * Created by adamli on 8/27/16.
 */
public class NaryTreeNode {
    int val;
    NaryTreeNode next[];

    public NaryTreeNode(int val) {
        this.val = val;
        this.next = new NaryTreeNode[3];
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
