/**
 * Created by adamli on 3/3/16.
 */
public class PermutationWithSwap {
    public static void permute(int[] input) {
        helper(input, 0);
    }

    public static void helper(int[] input, int index) {
        if (index == input.length) {
            for (int ele : input)
                System.out.print(ele + " ");

            System.out.println();
            return;
        }

        for (int i = index; i < input.length; i++) {
            swap(input, index, i);
            helper(input, index + 1);
            swap(input, index, i);
        }
    }

    public static void swap(int[] input, int l, int r) {
        int tmp = input[l];
        input[l] = input[r];
        input[r] = tmp;
    }
}
