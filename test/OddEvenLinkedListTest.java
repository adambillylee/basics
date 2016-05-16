import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/15/16.
 */
public class OddEvenLinkedListTest {
    OddEvenLinkedList sol = new OddEvenLinkedList();

    @Test
    public void oddEvenList1() throws Exception {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        head.next = two;
        two.next = three;
        three.next = four;

        head = sol.oddEvenList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    public void oddEvenList2() throws Exception {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        head = sol.oddEvenList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}