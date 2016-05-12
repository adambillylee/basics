import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 5/10/16.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList();

        helper(rst, new ArrayList<>(), 1, n, k);

        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> list, int index, int n, int k) {
        if (k == 0) {
            rst.add(new ArrayList(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            helper(rst, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
