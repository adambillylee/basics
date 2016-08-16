import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 5/11/16.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        // convert array into list for manipulation
        List<ListNode> list = new ArrayList();
        for (ListNode ele : lists)
            list.add(ele);

        while (list.size() > 1) {
            List<ListNode> next = new ArrayList();

            // merge listNodes pair by pair and add result into next iteration
            for (int i = 0; i < list.size() - 1; i += 2) {
                ListNode merged = mergeTwo(list.get(i), list.get(i + 1));
                next.add(merged);
            }

            // if list length is even, the last one would not be merged, add it into next iteration as well
            if (list.size() % 2 == 1) {
                next.add(0, list.get(list.size() - 1));
            }

            list = next;
        }
        return list.get(0);
    }

    // merge two sorted linked lists
    ListNode mergeTwo(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = new ListNode(-1);
        dummy.next = curr;

        while (head1 != null || head2 != null) {
            // if one of the input head is null, add the other into rst
            if (head1 == null) {
                curr.next = new ListNode(head2.val);
                head2 = head2.next;
                curr = curr.next;
                continue;
            }

            if (head2 == null) {
                curr.next = new ListNode(head1.val);
                head1 = head1.next;
                curr = curr.next;
                continue;
            }

            // if both of then are not null, add smaller one into result
            if (head1.val < head2.val) {
                curr.next = new ListNode(head1.val);
                head1 = head1.next;
                curr = curr.next;
            } else {
                curr.next = new ListNode(head2.val);
                head2 = head2.next;
                curr = curr.next;
            }



        }

        return dummy.next.next;
    }
}
