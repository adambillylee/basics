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

    @Test
    public void randomKElement() throws Exception {
        int size = 1000;

        int[] input = new int[size];
        for (int i=0; i<input.length; i++)
            input[i] = i+1;

        int[] prev = {1,2,3,4,5};

        for (int i = 5; i < size; i++) {
            int[] curr = RandomElementsInDataStream.randomKElements(input[i], i, prev);

            for (int j=0; j<5; j++) {
                System.out.print(prev[j] + " ");
            }

            System.out.println();
            prev = curr;
        }
    }
}