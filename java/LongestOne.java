public class LongestOne {
    public int longestOne(int[] array) {
        //corner cases
        int[] M = new int[array.length];

        int max = 0;
        M[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                M[i] = M[i - 1] + 1;

                if (M[i] > max) {
                    max = M[i];
                }
            } else {
                M[i] = 0;
            }
        }
        return max;
    }
}