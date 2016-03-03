import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 3/1/16.
 */
public class DfsAllValidParenthesis {
    public static List<List<String>> valid_parenthesis(int n) {
        List<List<String>> rst = new ArrayList<List<String>>();

        if (n == 0)
            return rst;

        helper(n, 0, 0, new ArrayList<String>(), rst);

        return rst;
    }

    /**
     * DFS helper for all parenthesis
     * @param n # of parenthesis pairs
     * @param l # of left parenthesis used so far
     * @param r # of right parenthesis used so far
     * @param list current partial result
     * @param rst final result
     */
    private static void helper(int n, int l, int r, ArrayList<String> list, List<List<String>> rst) {
        // base case
        if (l==n && r==n) {
            rst.add(new ArrayList<>(list));
            return;
        }

        // add left parenthesis
        if (l < n) {
            list.add("(");
            helper(n, l+1, r, list, rst);
            list.remove(list.size()-1);
        }

        // add right parenthesis
        if(r < l) {
            list.add(")");
            helper(n, l, r+1, list, rst);
            list.remove(list.size()-1);
        }
    }
}
