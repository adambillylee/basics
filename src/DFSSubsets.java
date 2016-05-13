import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 2/29/16.
 */
public class DfsSubsets {
    public static List<List<Integer>> subSets(int[] input) {
        List<List<Integer>> rst = new ArrayList<>();

        if (input == null || input.length == 0)
            return rst;

        helper(input, 0, new ArrayList<>(), rst);

        return rst;
    }

    public static void helper(int[] input, int index, List<Integer> list, List<List<Integer>> rst) {
        // base case
        if (index == input.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        // case1: add current number (input[index])
        // add and remove current number from list
        list.add(input[index]);
        helper(input, index+1, list, rst);
        list.remove(list.size()-1);

        // case2: don't add current number
        helper(input, index+1, list, rst);
    }

}