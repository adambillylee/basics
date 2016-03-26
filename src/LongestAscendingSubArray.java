/**
 * Created by adamli on 3/23/16.
 */
public class LongestAscendingSubArray {
    public int getLength(int[] input) {
        if (input.length == 0)
            return 0;

        /**
         * longest ascending array length from input[0~i] including i
         */
        int[] m = new int[input.length];

        // input[i] has longest ascending array length of 1
        m[0] = 1;

        /**
         * recursive relation
         */
        for (int i=1; i<input.length; i++) {
            if (m[i] > m[i-1]) {
                m[i] = m[i-1] + 1;
            }else{

            }
        }

        return 1;
    }
}
