import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by adamli on 7/31/16.
 */
public class RandomNumberWithArbitraryDistrTest {
    RandomNumberWithArbitraryDistr sol = new RandomNumberWithArbitraryDistr();

    @Test
    public void testRand() {
        int nums[] = {1,2,3};
        int dist[] = {1,2,3};
        Random ran = new Random();

        Map<Integer, Integer> count = new HashMap<>();
        for (int i =0; i< 100000; i++) {
            int tmp = sol.randomWithGivenDistr(nums, dist, ran);

            if (count.containsKey(tmp)) {
                count.put(tmp, count.get(tmp) +1);
            }else{
                count.put(tmp, 1);
            }
        }

        System.out.println(count.toString());
    }

}