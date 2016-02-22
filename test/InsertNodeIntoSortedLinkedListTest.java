import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class InsertNodeIntoSortedLinkedListTest {

    @Test
    public void testInsertMiddle() throws Exception {
        ListNode head = buildListFromArray(new int[]{1,3,5,7,9});

        InsertNodeIntoSortedLinkedList.insert(2, head);

        int[] expected = new int[]{1,2,3,5,7,9};
        for (int i=0; i<expected.length;i++) {
            assertEquals(expected[i], head.getVal());
            head = head.next;
        }
    }

    @Test
    public void testInsertEnd() throws Exception {
        ListNode head = buildListFromArray(new int[]{1,3,5,7,9});

        InsertNodeIntoSortedLinkedList.insert(11, head);

        int[] expected = new int[]{1,3,5,7,9,11};
        for (int i=0; i<expected.length;i++) {
            assertEquals(expected[i], head.getVal());
            head = head.next;
        }
    }

    @Test
    public void testInsertEmpty() throws Exception {
        ListNode head = null;

        head = InsertNodeIntoSortedLinkedList.insert(11, head);

        int[] expected = new int[]{11};
        for (int i=0; i<expected.length;i++) {
            assertEquals(expected[i], head.getVal());
            head = head.next;
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