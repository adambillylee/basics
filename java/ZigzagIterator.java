import java.util.List;

public class ZigzagIterator {
    List<Integer> v1;
    List<Integer> v2;
    int list;
    int[] curr;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.list = 0;
        this.curr = new int[2];
    }

    public int next() {
        int rst = 0;

        if (list == 0) {
            rst = v1.get(curr[list]);
            curr[list]++;
        } else {
            rst = v2.get(curr[list]);
            curr[list]++;
        }

        getOtherList();
        return rst;
    }

    public boolean hasNext() {
        if (list == 0) {
            if (curr[list] == v1.size()) {
                getOtherList();
                return !(curr[list] == v2.size());
            } else {
                return true;
            }
        } else {
            if (curr[list] == v2.size()) {
                getOtherList();
                return !(curr[list] == v1.size());
            } else {
                return true;
            }
        }
    }

    private void getOtherList() {
        if (list == 0)
            list = 1;
        else
            list = 0;
    }
}