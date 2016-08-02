import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adamli on 2/4/16.
 * all permutations with length = input length
 * with no order
 */
public class Permutation {
    public ArrayList<ArrayList<Integer>> permutation(int input[]) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();

        if (input.length == 0)
            return rst;

        helper(input, new ArrayList<Integer>(), rst);

        return rst;
    }

    public void helper(int input[], ArrayList<Integer> selected, ArrayList<ArrayList<Integer>> rst) {
        // add to result when selected length = input length
        if (selected.size() == input.length) {
            rst.add(new ArrayList<>(selected));
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (selected.contains(input[i]))
                continue;

            selected.add(input[i]);
            helper(input, selected, rst);
            selected.remove(selected.size() - 1);
        }
    }
}
