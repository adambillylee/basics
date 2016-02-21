import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class FindMiddleOfLinkedListTest {

    @Test
    public void testFindMidOdd() throws Exception {
        int[] input = {1,2,3,4,5};
        ListNode head = buildListFromArray(input);

        int expected = 3;

        int actual = FindMiddleOfLinkedList.findMid(head).getVal();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMidEven() throws Exception {
        int[] input = {1,2,3,4,5,6};
        ListNode head = buildListFromArray(input);

        int expected = 3;

        int actual = FindMiddleOfLinkedList.findMid(head).getVal();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMidEmpty() throws Exception {
        int[] input = {};
        ListNode head = buildListFromArray(input);

        int expected = -1;

        int actual = FindMiddleOfLinkedList.findMid(head).getVal();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMidOne() throws Exception {
        int[] input = {1};
        ListNode head = buildListFromArray(input);

        int expected = 1;

        int actual = FindMiddleOfLinkedList.findMid(head).getVal();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMidTwo() throws Exception {
        int[] input = {1,2};
        ListNode head = buildListFromArray(input);

        int expected = 1;

        int actual = FindMiddleOfLinkedList.findMid(head).getVal();

        assertEquals(expected, actual);
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