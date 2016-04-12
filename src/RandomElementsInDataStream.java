import java.util.Random;

/**
 * Created by adamli on 4/11/16.
 */
public class RandomElementsInDataStream {
    public static int[] randomElement(int[] input) {
        int curr = input[0];
        int[] rst = new int[input.length];

        Random rand = new Random();

        for (int i = 0; i < input.length; i++) {
            int random = rand.nextInt(i+1);

            if (random != 0)
                curr = input[random];

            rst[i] = curr;
        }

        return rst;
    }
}
