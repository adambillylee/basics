/**
 * Created by adamli on 3/15/16.
 */
public class ReOrderArray {
    public static int[] reorder(int[] array) {
        int end = array.length - 1;
        int mid = array.length / 2;

        int rst[] = new int[array.length];

        int i = 0;
        int j = mid;
        int k = 0;

        int flag = 1;
        while (k <= end) {
            if (flag == 1)
                rst[k++] = array[i++];

            if (flag == -1)
                rst[k++] = array[j++];

            flag = -1 * flag;

            // when input length is even, put the last number at the end
            if (i == mid && k < end)
                rst[k++] = array[j++];
        }


        return rst;
    }
}
