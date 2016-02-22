/**
 * Created by adamli on 2/21/16.
 */
public class InsertNodeIntoSortedLinkedList {
    public static ListNode insert(int target, ListNode head) {
        ListNode newNode = new ListNode(target);

        // case 1: empty head, return new node with next = null
        if (head == null) {
            head = newNode;
            return head;
        }

        /**
         * case 2: insert in middle or end
         * keep track of original head for return later
         */
        ListNode rtn = head;

        /**
         * find insert position
         * stop while head is at tail
         * or target < head.next
         */
        while(head.next != null && target > head.next.val) {
                head = head.next;
        }

        // store original next
        ListNode next = head.next;

        // insert node
        head.next = newNode;

        // put newnode.next = original next
        newNode.next = next;


        // return original head
        return rtn;
    }
}
