import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 7/24/16.
 */
public class SumWays {
    public List<String> sumWays(int n) {
        List<String> rst = new ArrayList<>();
        dfs(rst, n, "");
        return rst;
    }

    void dfs(List<String> rst, int remains, String s) {
        if (remains == 0) {
            s = s.substring(0, s.length() - 1);
            System.out.println(s);
            rst.add(s);
            return;
        }

        for (int i = 1; i <= remains; i++) {
            dfs(rst, remains - i, s + i + "+");
        }
    }
}
