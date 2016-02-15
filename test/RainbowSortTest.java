import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/13/16.
 */
public class RainbowSortTest {

    @Test
    public void testRainbowSort() throws Exception {
        char[] input = "abcccabbcbbaca".toCharArray();

        RainbowSort.RainbowSort(input);

        for (char i: input)
            System.out.print(i + " ");
    }
}