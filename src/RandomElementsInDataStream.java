import java.util.Random;

/**
 * Created by adamli on 4/11/16.
 */
public class RandomElementsInDataStream {
    public static int[] randomElement(int[] input) {
        int[] rst = new int[input.length];
        rst[0] = input[0];

        Random rand = new Random();

        for (int i = 1; i < input.length; i++) {
            int random = rand.nextInt(i+1);

            if (random == 0)
                rst[i] = rst[i-1];

            rst[i] = input[random];
        }

        return rst;
    }
}
