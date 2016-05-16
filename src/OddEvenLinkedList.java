/**
 * Created by adamli on 5/15/16.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        /**
         * even is ahead of odd, even.next will reach first null
         */
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = firstEven;

        return head;
    }
}
