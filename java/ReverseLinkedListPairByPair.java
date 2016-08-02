/**
 * reverse nodes in linkedlist pair by pair
 * Created by adamli on 3/21/16.
 */
public class ReverseLinkedListPairByPair {
    public static ListNode reverse(ListNode curr) {
        if (curr == null || curr.next == null)
            return curr;

        /**
         * for example, 1->2->3->4->null;
         * curr = 1
         * next = 2
         * nnext = 3
         */
        ListNode next = curr.next;
        ListNode nnext = next.next;

        // 2->1
        next.next = curr;

        // 1-> (reversed 3-> ...)
        curr.next = reverse(nnext);

        // since we want 2->1, 2 becomes new head (return to node in order curr-2)
        return next;
    }
}
