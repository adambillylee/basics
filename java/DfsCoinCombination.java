import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 3/1/16.
 */
public class DfsCoinCombination {
    public static List<List<Integer>> coinCombination(int sum, int[] coins) {
        List<List<Integer>> rst = new ArrayList<>();

        if (sum == 0 || coins.length == 0)
            return rst;

        helper(sum, coins, 0, new ArrayList<Integer>(), rst);

        return rst;
    }

    /**
     * each DFS level represent which coin to take(or not)
     *
     * @param remaining total sum, objective
     * @param coins     all possible coins
     * @param index     index in coins array
     * @param list      current combination
     * @param rst       global result
     */
    private static void helper(int remaining, int[] coins, int index,
                               List<Integer> list, List<List<Integer>> rst) {
        if (remaining == 0) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        if (remaining < 0 || index == coins.length)
            return;

        // case 1: add current element
        remaining = remaining - coins[index];
        list.add(coins[index]);
        helper(remaining, coins, index, list, rst);
        remaining = remaining + coins[index];
        list.remove(list.size() - 1);

        // case 2: add next element
        helper(remaining, coins, index + 1, list, rst);
    }

}
