import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/13/16.
 */
public class MergeSortAlphabetTest {

    @Test
    public void testMergeSort() throws Exception {
        char[] input = "A1B2C3D4E5".toCharArray();

        MergeSortAlphabet.MergeSort(input);

        System.out.println(input);
    }
}