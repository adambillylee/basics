import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class ReOrderLinkedListTest {

    @Test
    public void testReOrder() throws Exception {
        int[] input = {1,2,3,4,5,6};
        ListNode head = buildListFromArray(input);

        ListNode reOrdered = ReOrderLinkedList.reOrder(head);

        int[] expected = {1,6,2,5,3,4};
        for(int i=0; i<expected.length;i++) {
            assertEquals(expected[i], reOrdered.getVal());
            reOrdered = reOrdered.next;
        }
    }

    public ListNode buildListFromArray(int[] input) {
        if (input == null || input.length == 0)
            return new ListNode(-1);

        ListNode head = new ListNode(input[0]);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int i=1; i<input.length; i++) {
            head.next = new ListNode(input[i]);
            head = head.next;
        }

        return dummy.next;
    }
}