import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by adamli on 2/5/16.
 */
public class Permutation_with_dedup {
    public ArrayList<ArrayList<Integer>> permutation(int input[]) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();

        // sort to put all dups together
        Arrays.sort(input);

        if (input.length == 0)
            return rst;

        // visited array for dedup
        int visited[] = new int[input.length];

        helper(input, new ArrayList<Integer>(), rst, visited);

        return rst;
    }

    public void helper(int input[], ArrayList<Integer> selected, ArrayList<ArrayList<Integer>> rst, int visited[]) {
        // add to result when selected length = input length
        if (selected.size() == input.length) {
            rst.add(new ArrayList<>(selected));
            return;
        }

        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            // because input is sorted and all dups are put together
            // so if prevous = current element, skip it
            if (visited[i] == 1 || prev == visited[i])
                continue;

            prev = input[i];
            selected.add(input[i]);
            visited[i] = 1;

            helper(input, selected, rst, visited);

            selected.remove(selected.size() - 1);
            visited[i] = 0;
        }
    }
}
