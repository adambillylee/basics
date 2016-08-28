import org.testng.annotations.Test;

/**
 * Created by adamli on 8/27/16.
 */
public class SeralizeAndDeseralizeNaryTreeTest {
    SeralizeAndDeseralizeNaryTree sol = new SeralizeAndDeseralizeNaryTree();

    @Test
    public void testSerialize() throws Exception {
        NaryTreeNode root = new NaryTreeNode(0);
        NaryTreeNode one = new NaryTreeNode(1);
        NaryTreeNode two = new NaryTreeNode(2);
        NaryTreeNode three = new NaryTreeNode(3);
        NaryTreeNode four = new NaryTreeNode(4);
        NaryTreeNode five = new NaryTreeNode(5);
        NaryTreeNode six = new NaryTreeNode(6);

        one.next[0] = (three);
        one.next[1] = (four);
        two.next[0] = (five);
        three.next[0] = (six);

        root.next[0] = (one);
        root.next[1] = (two);

        String codex = sol.serialize(root);
        System.out.println(codex);

        NaryTreeNode reverse = sol.deSeralize(codex);
    }

}