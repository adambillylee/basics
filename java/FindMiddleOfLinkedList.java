/**
 * Created by adamli on 2/21/16.
 */
public class FindMiddleOfLinkedList {
    public static ListNode findMid(ListNode head) {
        if (head == null)
            return new ListNode(-1);

        // put both starting point to be head
        ListNode slow = head;
        ListNode fast = head;

        // check fast.next and fast.next.next to be consistent
        while(fast.next!= null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //alternatively, return slow.next for head of later half
        return slow;
    }
}
