import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class FindLoopInLinkedListTest {

    @Test
    public void testFindLoopInLinkedListOneNode() throws Exception {
        ListNode head = new ListNode(1);
        head.next = null;

        boolean expected = false;
        boolean actual = FindLoopInLinkedList.findLoopInLinkedList(head);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindLoopInLinkedListTwoNodes() throws Exception {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        two.next = head;

        boolean expected = true;
        boolean actual = FindLoopInLinkedList.findLoopInLinkedList(head);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindLoopInLinkedListNoLoop() throws Exception {
        ListNode head = buildListFromArray(new int[]{1,2,3,4,5});

        boolean expected = false;

        assertEquals(expected, FindLoopInLinkedList.findLoopInLinkedList(head));
    }

    @Test
    public void testFindLoopInLinkedListHasLoop() throws Exception {
        ListNode head = buildListFromArray(new int[]{1,2,3,4,5});

        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = six;
        six.next = seven;
        seven.next = tail;

        boolean expected = true;

        assertEquals(expected, FindLoopInLinkedList.findLoopInLinkedList(head));
    }

    public ListNode buildListFromArray(int[] input) {
        if (input == null || input.length == 0)
            return new ListNode(-1);

        ListNode head = new ListNode(input[0]);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int i=1; i<input.length; i++) {
            head.next = new ListNode(input[i]);
            head = head.next;
        }

        return dummy.next;
    }
}