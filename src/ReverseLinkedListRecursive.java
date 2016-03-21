/**
 * Created by adamli on 2/21/16.
 */
public class ReverseLinkedListRecursive {
    public static ListNode reverse(ListNode node) {
        // base case
        if (node == null || node.next == null)
            return node;

        /**
         * reversed head node
         * with next link all the way to next node
         */
        ListNode reverseHead = reverse(node.next);

        /**
         * with reverse head -> next node
         * fix next node to current node link
         */
        node.next.next = node;

        // curr node should point to null
        node.next = null;

        // still return that reversed had node to next level
        return reverseHead;
    }
}
