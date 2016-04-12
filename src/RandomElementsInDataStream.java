import java.util.Random;

/**
 * Created by adamli on 4/11/16.
 */
public class RandomElementsInDataStream {
    public static int randomElement(int input, int size, int prev) {
        Random rand = new Random();

        int random = rand.nextInt(size + 1);

        if (random == 0)
            return input;
        else
            return prev;
    }

    public static int[] randomKElements(int input, int size, int[] prev) {
        int k = 5;

        Random rand = new Random();

        int random = rand.nextInt(size + 1);

        if (random < k) {
            prev[random] = input;
            return prev;
        } else {
            return prev;
        }
    }
}
