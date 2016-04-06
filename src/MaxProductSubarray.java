public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        int max[] = new int[nums.length+1];
        int min[] = new int[nums.length+1];

        max[0] = 1;
        min[0] = 1;
        int maxProd = Integer.MIN_VALUE;

        for (int i=1; i<=nums.length; i++) {
            if (nums[i-1]>0) {
                max[i] = Math.max(max[i-1] * nums[i-1], nums[i-1]);
                min[i] = Math.min(min[i-1] * nums[i-1], nums[i-1]);
            }else{
                max[i] = Math.max(min[i-1] * nums[i-1], nums[i-1]);
                min[i] = Math.min(max[i-1] * nums[i-1], nums[i-1]);
            }

            if (maxProd < max[i]) {
                maxProd = max[i];
            }
        }

        return maxProd;
    }
}