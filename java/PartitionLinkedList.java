/**
 * Created by adamli on 2/21/16.
 */
public class PartitionLinkedList {
    public static ListNode partition(ListNode head, int target) {
        if (head == null)
            return head;

        // 1. find target
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        ListNode dummyLeft = leftHead;
        ListNode dummyRight = rightHead;


        while(head != null) {
            if (head.val < target) {
                leftHead.next = new ListNode(head.val);
                leftHead = leftHead.next;
            }else if (head.val > target) {
                rightHead.next = new ListNode(head.val);
                rightHead = rightHead.next;
            }

            head = head.next;
        }

        leftHead.next = new ListNode(target);
        leftHead = leftHead.next;
        leftHead.next = dummyRight.next;

        return dummyLeft.next;
    }
}
