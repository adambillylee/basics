/**
 * Created by adamli on 6/28/16.
 */
public class StackWithLinkedList {
    ListNode head = null;
    int size = 0;

    void add(int i) {
        if (head == null) {
            head = new ListNode(i);
        } else {
            ListNode tmp = new ListNode(i);
            tmp.next = head;
            head = tmp;
        }

        size++;
    }

    int peak() throws Exception {
        if (size == 0) {
            throw new Exception("Stack underflow");
        }

        return head.getVal();
    }

    int pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack underflow");
        }

        int rst = head.getVal();
        head = head.next;
        size--;

        return rst;
    }

    int size() {
        return size;
    }
}
