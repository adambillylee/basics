import java.util.PriorityQueue;

/**
 * Created by adamli on 8/17/16.
 */
public class MergeKSortedListWithHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2)->(n1.val - n2.val));

        for (ListNode tmp : lists) {
            if (tmp != null)
                heap.add(tmp);
        }

        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            curr.next = min;
            curr = curr.next;

            if (min.next != null)
                heap.offer(min.next);
        }

        return dummy.next;
    }
}
