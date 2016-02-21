/**
 * Created by adamli on 2/21/16.
 */
public class FindMiddleOfLinkedList {
    public static ListNode findMid(ListNode head) {
        if (head == null || head.next == null)
            return new ListNode(-1);

        // put slow at head and fast at head.next to grantee correctness at even and odd case
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //alternatively, return slow.next for head of later half
        return slow;
    }
}
