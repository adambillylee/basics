import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class PartitionLinkedListTest {

    @Test
    public void testPartition() throws Exception {
        int[] input = new int[]{3,5,6,16,83,15,4,57,67};
        int target = 7;

        ListNode head = buildListFromArray(input);
        ListNode partitioned = PartitionLinkedList.partition(head, target);

        int[] expected = new int[]{3,5,6,4,7,16,83,15,57,67};
        for(int i=0; i<input.length;i++) {
            assertEquals(expected[i], partitioned.val);
            partitioned = partitioned.next;
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