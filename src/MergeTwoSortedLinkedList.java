/**
 * Created by adamli on 2/21/16.
 */
public class MergeTwoSortedLinkedList {
    public static ListNode merge(ListNode head1, ListNode head2) {
        // deal with empty input
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;

        ListNode head = new ListNode(-1);
        ListNode org = head;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                head.next = new ListNode(head2.getVal());
                head2 = head2.next;
                continue;
            }

            if (head2 == null) {
                head.next = new ListNode(head1.getVal());
                head1 = head1.next;
                continue;
            }

            if (head1.getVal() <= head2.getVal()) {
                head.next = new ListNode(head1.getVal());
                head1 = head1.getNext();
            } else {
                head.next = new ListNode(head2.getVal());
                head2 = head2.getNext();
            }

            head = head.next;
        }


        return org.next;
    }
}
