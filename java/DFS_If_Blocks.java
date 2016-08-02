import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 3/3/16.
 */
public class DFS_If_Blocks {
    public static void if_blocks(int n) {
        helper(n, 0, 0, new ArrayList<String>());
    }

    public static void helper(int n, int l, int r, List<String> list) {
        if (l == n && r == n) {
            for (String ele : list) {
                System.out.print(ele);
            }
            System.out.println("----------------------");
            return;
        }

        int count = l - r;

        if(l < n) {
            StringBuilder sb = new StringBuilder();

            for (int i=0;i<count;i++) {
                sb.append("  ");
            }
            sb.append("if {\n");

            String left = sb.toString();

            list.add(left);
            helper(n, l+1, r, list);
            list.remove(list.size()-1);
        }

        count = l - r;

        if (r<l) {
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<count;i++) {
                sb.append("  ");
            }
            sb.append("}\n");

            String right = sb.toString();

            list.add(right);
            helper(n, l, r+1, list);
            list.remove(list.size()-1);
        }
    }
}