import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adamli on 5/23/16.
 */
public class InterceptionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums1) {
            if (count.get(num) == null) {
                count.put(num, 1);
            } else {
                count.put(num, count.get(num) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (count.get(num) != null) {
                list.add(num);

                int remains = count.get(num) - 1;

                if (remains == 0)
                    count.remove(num);
                else
                    count.put(num, remains);
            }
        }

        int[] rst = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            rst[i] = list.get(i);

        return rst;
    }
}
