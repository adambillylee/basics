import org.junit.Test;

import java.util.Arrays;

/**
 * Created by adamli on 12/28/15.
 */
public class BSTTest {
    Node root = new Node(10,10);
    BST sol = new BST(root);

    public void setUp() {
        sol.put(5,5);
        sol.put(1,1);
        sol.put(7,7);
        sol.put(100,100);
        sol.put(73,73);
        sol.put(500,500);
        sol.put(224, 224);
    }

    @Test
    public void testTree() throws Exception {
        sol.put(2,2);
        sol.put(3,3);
        sol.put(4,4);
        sol.put(5,5);

        System.out.println(sol.get(3));
    }

    @Test
    public void testSort() throws Exception {
        setUp();
        sol.recursiveInOrder();
    }

    @Test
    public void testMinMax() throws Exception {
        setUp();
        sol.min();
        sol.max();
    }

    @Test
    public void testSize() throws Exception {
        setUp();
        System.out.println(sol.size());
    }

    @Test
    public void testRank() throws Exception {
        setUp();
        System.out.println(sol.rank(224));
        System.out.println(sol.rank(1));
    }

    @Test
    public void testInOrderIteratively() throws Exception {
        setUp();
        sol.iterativeInOrder();
    }

    @Test
    public void testInRangeCount() throws Exception {
        setUp();

        System.out.println(sol.size(71,150));
        System.out.println("-----------------");
        sol.nodeInRange(71, 150);
        System.out.println();

        System.out.print(sol.size(0,34));
        System.out.println("-----------------");
        sol.nodeInRange(0,34);
    }
}