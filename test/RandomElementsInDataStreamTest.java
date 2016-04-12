import org.junit.Test;

import java.util.Random;

/**
 * Created by adamli on 4/12/16.
 */
public class RandomElementsInDataStreamTest {
    @Test
    public void randomElement() throws Exception {
        int[] input = new int[1000];
        for (int i=0; i<input.length; i++)
            input[i] = i+1;

        int prev = input[0];

        for (int i = 1; i < 1000; i++) {
            int curr = RandomElementsInDataStream.randomElement(input[i], i, prev);
            System.out.println(curr);
            prev = curr;
        }
    }

}