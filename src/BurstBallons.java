import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adamli on 6/28/16.
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        List<Integer> number = new ArrayList<>();
        for (int i : nums)
            number.add(i);

        Map<List<Integer>, Integer> map = new HashMap<>();
        return helper(number, map);
    }

    private int helper(List<Integer> number, Map<List<Integer>, Integer> map) {
        if (map.containsKey(number))
            return map.get(number);

        if (number.size() == 1)
            return number.get(0);

        int sum = 0;

        for (int i = 0; i < number.size(); i++) {
            int left = i - 1 >= 0 ? number.get(i - 1) : 1;
            int right = i + 1 < number.size() ? number.get(i + 1) : 1;
            int curr = left * number.get(i) * right;

            List<Integer> next = new ArrayList<>(number);
            next.remove(i);

            sum = Math.max(sum, curr + helper(next, map));
        }

        map.put(number, sum);
        return sum;
    }
}
