import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/11/16.
 */
public class RandomShufflingTest {
    @Test
    public void shuffle() throws Exception {
        int[] input ={1,2,3,4,5,6,7,8,9,10};
        RandomShuffling.shuffle(input);

        for (int ele : input) {
            System.out.println(ele);
        }
    }

}