import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by adamli on 6/6/16.
 */
public class isPalindromeListTest {
    isPalindromeList sol = new isPalindromeList();

    @Test
    public void isPalindrome() throws Exception {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        assertTrue(sol.isPalindrome(one));
    }

    @Test
    public void isPalindrome2() throws Exception {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        assertFalse(sol.isPalindrome(one));
    }

    @Test
    public void isPalindrome3() throws Exception {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;

        assertTrue(sol.isPalindrome(one));
    }

}