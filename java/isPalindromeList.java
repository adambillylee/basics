/**
 * Created by adamli on 6/6/16.
 */
public class isPalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        if (head.next == null)
            return true;

        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;
        ListNode next = s.next;

        /**
         * find middle point using slow && fast
         * and reverse all nodes up to slow
         */
        while (f.next != null && f.next.next != null) {
            f = f.next.next;

            s.next = prev;
            prev = s;
            s = next;
            next = next.next;
        }

        /**
         * if next.next != null, there are even number of nodes
         * 1->2->2->1, for example
         * where s is staying at first 2
         */
        if (f.next != null) {
            // reverse current slow (1<-2->2->1)
            s.next = prev;

            // move prev one step forward (prev to first two)
            prev = s;
        }

        /**
         * now, prev at start of reversed first have (not including middle node in off case)
         * next at start of second half (not including middle node)
         * compare one by one
         */
        while (prev != null && next != null) {
            if (prev.val != next.val)
                return false;

            prev = prev.next;
            next = next.next;
        }

        return true;
    }
}
