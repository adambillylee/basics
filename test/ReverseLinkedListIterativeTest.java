import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by adamli on 2/21/16.
 */
public class ReverseLinkedListIterativeTest {
    ListNode node = null;

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

        this.node = dummy.next;
    }

    @Test
    public void testReverse() throws Exception {
        ListNode reversed = ReverseLinkedListIterative.reverse(node);

        ArrayList expected = new ArrayList();
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(1);

        while(reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }

}