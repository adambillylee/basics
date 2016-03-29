import org.junit.Before;
import org.junit.Test;

/**
 * Created by adamli on 3/21/16.
 */
public class ReverseLinkedListPairByPairTest {
    ListNode node;

    @Before
    public void setUp() throws Exception {
        ListNode dummy = new ListNode(-1);

        ListNode node = new ListNode(1);
        dummy.next = node;

        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;

        this.node = dummy.next;
    }

    @Test
    public void reverse() throws Exception {
        ListNode reversedHead = ReverseLinkedListPairByPair.reverse(node);

        // press all nodes
        while (reversedHead != null) {
            System.out.println(reversedHead.val);
            reversedHead = reversedHead.next;
        }
    }
}