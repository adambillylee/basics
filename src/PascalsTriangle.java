import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 7/21/16.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();

        if (numRows == 0)
            return rst;

        // add the peak to kick off the loop
        rst.add(new ArrayList<>());
        rst.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            rst.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                rst.get(i).add(getNum(i, j, rst));
            }
        }

        return rst;
    }

    private int getNum(int i, int j, List<List<Integer>> rst) {
        if (i == j || j == 0)
            return 1;

        // number on top left + number on top
        int topLeft =  rst.get(i - 1).get(j - 1);
        int top = rst.get(i - 1).get(j);

        return topLeft + top;
    }
}
