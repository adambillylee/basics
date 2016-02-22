import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class MergeTwoSortedLinkedListTest {

    @Test
    public void testMergeNormal() throws Exception {
        ListNode head1 = buildListFromArray(new int[]{1,3,5,7});
        ListNode head2 = buildListFromArray(new int[]{2,4,6});

        ListNode merged = MergeTwoSortedLinkedList.merge(head1, head2);

        int[] expected = {1,2,3,4,5,6,7};
        for (int i=0; i<expected.length;i++) {
            assertEquals(expected[i], merged.getVal());
            merged = merged.next;
        }
    }

    @Test
    public void testMergeH1Empty() throws Exception {
        ListNode head1 = buildListFromArray(new int[]{1,3,5,7});
        ListNode head2 = null;

        ListNode merged = MergeTwoSortedLinkedList.merge(head1, head2);

        int[] expected = {1,3,5,7};
        for (int i=0; i<expected.length;i++) {
            assertEquals(expected[i], merged.getVal());
            merged = merged.next;
        }
    }

    @Test
    public void testMergeH2Empty() throws Exception {
        ListNode head1 = null;
        ListNode head2 = buildListFromArray(new int[]{1,3,5,7});

        ListNode merged = MergeTwoSortedLinkedList.merge(head1, head2);

        int[] expected = {1,3,5,7};
        for (int i=0; i<expected.length;i++) {
            assertEquals(expected[i], merged.getVal());
            merged = merged.next;
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