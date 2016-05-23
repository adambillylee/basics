import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by adamli on 5/23/16.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numbers = new HashSet<>();

        // add all numbers of nums1 into set
        for (int num : nums1) {
            numbers.add(num);
        }

        // if numbers in nums2 in numbers set, add it into intersect set
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (numbers.contains(num))
                intersect.add(num);
        }

        // convert intersect set to int[]
        int[] rst = new int[intersect.size()];
        Iterator<Integer> iterator = intersect.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            rst[i++] = iterator.next();
        }

        return rst;
    }
}
