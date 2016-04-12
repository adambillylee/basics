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
}
