/**
 * Created by adamli on 7/17/16.
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int l = 0, r = 0, rst = 0;
        while (l < r) {
            int tmp;
            if (height[l] < height[r]) {
                tmp = l;
                l++;
            } else if (height[l] > height[r]) {
                tmp = r;
                r--;
            } else {
                tmp = l;
                l++;
                r--;
            }

            rst += (Math.min(height[l], height[r]) - height[tmp]) > 0 ?
                    (Math.min(height[l], height[r]) - height[tmp]) : 0;
        }

        return rst;
    }
}
