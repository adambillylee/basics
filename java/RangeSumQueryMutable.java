/**
 * Created by adamli on 6/6/16.
 */
public class RangeSumQueryMutable {
    /**
     * define segment tree
     */
    class BinaryIndexTreeNode {
        int start;
        int end;
        int sum;

        BinaryIndexTreeNode left;
        BinaryIndexTreeNode right;
    }

    int sum[];
    int nums[];
    BinaryIndexTreeNode root = new BinaryIndexTreeNode();

    public RangeSumQueryMutable(int[] nums) {
        // corner case: empty nums
        if (nums.length == 0)
            return;

        // save nums for calculating delta later
        this.nums = nums;

        // sum array for O(1) calculation of range sum
        sum = new int[nums.length];

        // build sum array O(N)
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        // build segment tree
        root = buildTree(sum, 0, nums.length - 1);
    }

    // update value by index
    void update(int i, int val) {
        // calculate delta, for updating path in segment tree
        int delta = val - nums[i];

        // update segment tree from root with delta
        updateSum(i, delta, root);

        // update nums array to next delta calculations
        nums[i] = val;
    }

    private void updateSum(int i, int delta, BinaryIndexTreeNode root) {
        /**
         * base case:
         * update the leaf current root contains index i only
         */
        if (root.start == i && root.end == i) {
            root.sum += delta;
            return;
        }

        // update sum with delta
        root.sum += delta;

        /**
         * segment tree always use mid of current root to decide where to go
         */
        int mid = root.start + (root.end - root.start) / 2;

        if (i <= mid) {
            // if target index is <= current root mid, go left, since mid is included in left
            updateSum(i, delta, root.left);
        } else {
            // if target index is > current root mid, go right
            updateSum(i, delta, root.right);
        }
    }

    // return range sum O(log N)
    public int sumRange(int i, int j) {
        return searchSum(i, j, root);
    }

    private int searchSum(int start, int end, BinaryIndexTreeNode root) {
        /**
         * return sum is start and end is exact fit of current root
         */
        if (start == root.start && end == root.end)
            return root.sum;

        // segment tree: use mid of current node to decide where to go
        int mid = root.start + (root.end - root.start) / 2;

        if (end <= mid) {
            /**
             * if end <= mid, both start and end are in left tree
             * search left tree for sum
             */
            return searchSum(start, end, root.left);
        } else if (start >= mid + 1) {
            /**
             * if start >= mid +1
             * both start and end are in right tree
             * search right tree for sum
             */
            return searchSum(start, end, root.right);
        } else {
            /**
             * if not the 2 cases above, than half of start ~ end is in left and other have are in right
             * search left tree for start-> mid sum
             * search right tree for mid+1 -> end sum
             * add two sum together and return
             */
            return searchSum(start, mid, root.left) + searchSum(mid + 1, end, root.right);
        }
    }

    // build segment tree
    public BinaryIndexTreeNode buildTree(int sum[], int start, int end) {
        BinaryIndexTreeNode root = new BinaryIndexTreeNode();
        root.start = start;
        root.end = end;

        // calculate range sum: sum[1~3] = sum[3] - sum[0], sum[0~3] = sum[3]
        root.sum = sum[end];
        if (start > 0)
            root.sum -= sum[start - 1]; // -sum[1] in example above

        // if start == end, we are at root and directly return
        if (start != end) {
            int mid = start + (end - start) / 2;

            /**
             * left tree contains range sum of start ~ mid
             */
            root.left = buildTree(sum, start, mid);

            /**
             * right tree contains range sum of mid+1 ~ right
             */
            root.right = buildTree(sum, mid + 1, end);
        }

        return root;
    }
}
