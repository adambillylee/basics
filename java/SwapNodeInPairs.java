/**
 * Created by adamli on 8/24/16.
 */
public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;

        while (true) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;

            if (second.next != null && second.next.next != null) {
                first = first.next.next;
                second = second.next.next;
            }else {
                return head;
            }
        }
    }
}
