import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/12/16.
 */
public class RandomElementsInDataStreamTest {
    @Test
    public void randomElement() throws Exception {
        int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int[] rst = RandomElementsInDataStream.randomElement(input);

        for (int ele : rst) {
            System.out.println(ele);
        }
    }

}