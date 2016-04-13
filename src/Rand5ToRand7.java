import java.util.Random;

/**
 * Created by adamli on 4/12/16.
 */
public class Rand5ToRand7 {
    private static int rand5() {
        Random rand = new Random();
        return rand.nextInt(5);
    }

    public static int rand7() {
        // 5->25
        int rand25 = 5 * rand5() + rand5();

        // 25 ->21
        while (rand25 > 20) {
            rand25 = 5 * rand5() + rand5();
        }

        int rand21 = rand25;

        // 21 -> 7
        return rand21 % 7;
    }
}
