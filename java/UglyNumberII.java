import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 5/12/16.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        // list of all mins
        List<Integer> rst = new ArrayList<>();

        rst.add(1);

        // use cursor to specify which min value in result should be used to generate next candidate min
        int curr2 = 0;
        int curr3 = 0;
        int curr5 = 0;
        int min = 1;


        while (rst.size() < n) {
            // calculate 3 candidate mins
            int t2 = rst.get(curr2) * 2;
            int t3 = rst.get(curr3) * 3;
            int t5 = rst.get(curr5) * 5;

            min = Math.min(Math.min(t2, t3), t5);
            rst.add(min);

            // move the corresponding cursor forward
            if (min == t2) {
                curr2++;
            }

            if (min == t3) {
                curr3++;
            }

            if (min == t5) {
                curr5++;
            }
        }

        return min;
    }
}
