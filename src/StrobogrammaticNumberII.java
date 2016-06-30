import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adamli on 6/29/16.
 */
public class StrobogrammaticNumberII {
    Map<String, String> self;
    Map<String, String> pair;

    public List<String> findStrobogrammatic(int n) {
        List<String> rst = new ArrayList<>();

        if (n <= 0)
            return rst;

        self = new HashMap<>();
        pair = new HashMap<>();

        self.put("1", "1");
        self.put("0", "0");
        self.put("8", "8");
        pair.putAll(self);
        pair.put("6", "9");
        pair.put("9", "6");

        if (n % 2 == 0) {
            helper(rst, "", n, n);
        } else {
            for (String i : self.keySet()) {
                helper(rst, i, n - 1, n);
            }
        }

        return rst;
    }

    private void helper(List<String> rst, String s, int len, int n) {
        if (len <= 0) {
            rst.add(s);
            return;
        }

        for (String i : pair.keySet()) {
            if (len == 2 && i.equals("0"))
                continue;

            helper(rst, i + s + pair.get(i), len - 2, n);
        }
    }
}
