/**
 * Created by adamli on 2/21/16.
 */
public class ReOrderLinkedList {
    public static ListNode reOrder(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 1. find middle point
        ListNode slow = head;
        ListNode fast = head;

        /**
         * bug here: || instead of &&, need to make sure both condition not null
         */
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2. reverse later half of linkedlist
        ListNode firstHead = head;
        ListNode secondHead = slow.next;

        ListNode pre = null;
        ListNode curr = secondHead;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        secondHead = pre;
        slow.next = null;

        // 3. merge two arrays
        curr = new ListNode(-1);
        ListNode dummy = new ListNode(-1);
        dummy = curr;

        int flag = 1;

        while (firstHead != null || secondHead != null) {
            if (flag == 1) {
                curr.next = new ListNode(firstHead.getVal());
                curr = curr.next;
                firstHead = firstHead.next;
            } else {
                curr.next = new ListNode(secondHead.getVal());
                curr = curr.next;
                secondHead = secondHead.next;
            }

            flag = flag * -1;
        }

        return dummy.next;
    }
}
