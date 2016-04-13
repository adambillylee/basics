import java.util.Random;

/**
 * Created by adamli on 4/12/16.
 */
public class Rand21ToRand7 {
    static Random rand = new Random();

    private static int rand21() {
        return rand.nextInt(21);
    }

    public static int rand7() {
        int r21 = rand21();

        return r21 % 7 + 1;
    }
}
