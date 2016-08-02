import java.util.Random;

/**
 * Created by adamli on 4/11/16.
 */
public class RandomShuffling {
    public static void shuffle(int[] input) {
        int m = input.length;
        Random rand = new Random();

        for (int i = m - 1; i >= 0; i--) {
            // random bound cannot be zero
            int random = rand.nextInt(i+1);
            swap(input, random, i);
        }
    }

    private static void swap(int[] input, int left, int right) {
        int tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }
}
