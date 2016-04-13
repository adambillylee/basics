import java.util.Random;

/**
 * Created by adamli on 4/12/16.
 */
public class Rand5ToRand25 {
    static Random rand = new Random();

    private static int rand5() {
        return rand.nextInt(5);
    }

    public static int rand25() {
        return 5 * rand5() + rand5();
    }
}
