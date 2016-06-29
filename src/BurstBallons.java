import java.util.*;

/**
 * Created by adamli on 6/28/16.
 */
public class BurstBallons {
    LinkedList<Integer> path = new LinkedList();
    Long dp = 0L;

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        List<Integer> number = new ArrayList<>();
        for (int i : nums)
            number.add(i);

        Map<List<Integer>, Integer> map = new HashMap<>();

        int rst = helper(number, map);
        System.out.println("dp:\t" + dp);
        System.out.println("total:\t" + factorial(nums.length));

        return rst;
    }

    private int helper(List<Integer> number, Map<List<Integer>, Integer> map) {
        if (map.containsKey(number)) {
            dp++;
            return map.get(number);
        }



        if (number.size() == 1) {
            path.add(number.get(0));
            System.out.println(path.toString());
            path.remove(number.get(0));
            return number.get(0);
        }

        int sum = 0;

        for (int i = 0; i < number.size(); i++) {
            int left = i - 1 >= 0 ? number.get(i - 1) : 1;
            int right = i + 1 < number.size() ? number.get(i + 1) : 1;
            int curr = left * number.get(i) * right;
            path.add(number.get(i));
            System.out.println(path.toString());

            List<Integer> next = new ArrayList<>(number);
            next.remove(i);

            sum = Math.max(sum, curr + helper(next, map));
            path.remove(number.get(i));
        }

        map.put(number, sum);
        return sum;
    }

    public static Long factorial(int n) {
        Long fact = 1L; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
