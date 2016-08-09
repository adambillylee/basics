import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by adamli on 8/8/16.
 */
public class Solution {
    List<Integer> list = new ArrayList<>();

    public int topK(Iterator<Integer> iterator, int k) {
        int rst = 0;
        while (iterator.hasNext()) {
            while (list.size() < 2 * k && iterator.hasNext()) {
                list.add(iterator.next());
            }

            // quick select, move > top to the later part
            rst = quickSelect(list, k);

            // drop everything before top k
            if (list.size() == 2 * k)
                list = list.subList(0, k);
        }

        return rst;
    }

    private int quickSelect(List<Integer> list, int k) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            int tmp = partition(list, lo, hi);

            if (tmp == k - 1) {
                return list.get(k - 1);
            } else if (tmp < k - 1) {
                lo = tmp + 1;
            } else {
                hi = tmp - 1;
            }
        }

        return list.get(k - 1);
    }

    private int partition(List<Integer> list, int lo, int hi) {
        int pivot = list.get(hi);

        int boundary = lo;

        for (int i = lo; i < hi; i++) {
            if (list.get(i) > pivot) {
                swap(i, boundary);
                boundary++;
            }
        }

        swap(boundary, hi);

        return boundary;
    }

    private void swap(int i, int boundary) {
        int tmp = list.get(i);
        list.set(i, list.get(boundary));
        list.set(boundary, tmp);
    }
}
