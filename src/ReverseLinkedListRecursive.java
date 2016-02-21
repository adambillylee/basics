/**
 * Created by adamli on 2/21/16.
 */
public class ReverseLinkedListRecursive {
    public static ListNode reverse(ListNode node) {
        // base case
        if (node == null || node.next == null)
            return node;

        ListNode next = node.next;

        ListNode newHead = reverse(next);

        next.next = node;
        node.next = null;

        return newHead;
    }
}
