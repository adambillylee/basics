import java.util.ArrayList;

/**
 * Created by adamli on 2/5/16.
 */
public class PowerSet {
    public static ArrayList<ArrayList<Integer>> powerSet(int input[]) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();

        if (input.length == 0)
            return rst;

        helper(rst, new ArrayList<Integer>(), input, 0);

        return rst;
    }

    public static void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> currSet, int input[], int indToSelect) {
        if (indToSelect == input.length + 1)
            return;

        rst.add(new ArrayList<>(currSet));

        // use indToSelect to specify where to start looking for value
        for (int i = indToSelect; i < input.length; i++) {
            currSet.add(input[i]);
            helper(rst, currSet, input, i + 1);
            currSet.remove(currSet.size() - 1);
        }
    }
}
