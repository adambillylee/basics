/**
 * Created by adamli on 5/3/16.
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int leftToR[] = new int[n];
        int rightToL[] = new int[n];

        // from left to right, if previous score is higher, add curr candy by 1
        leftToR[0] = 1;
        for (int i=1; i<n; i++) {
            if (ratings[i-1] < ratings[i])
                leftToR[i] = leftToR[i-1]+1;
            else
                leftToR[i] = 1;
        }

        // from right to left, if next score is higher, add curr candy by 1
        rightToL[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            if (ratings[i+1] < ratings[i])
                rightToL[i] = rightToL[i+1]+1;
            else
                rightToL[i]=1;
        }

        // for each child, take the max candy from (left to right) and (right to left)
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += Math.max(leftToR[i], rightToL[i]);
        }

        return sum;
    }
}
