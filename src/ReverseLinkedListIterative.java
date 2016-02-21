import java.util.List;

/**
 * Created by adamli on 2/21/16.
 */
public class ReverseLinkedListIterative {
    public static ListNode reverse(ListNode node) {
        ListNode pre = null;

        while(node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public int getVal() {return this.val;}
}

