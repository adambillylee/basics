import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/8/16.
 */
public class FindMissingNumberInUnsortedArrayTest {

    @Test
    public void testFindMissing() throws Exception {
        int[] input = {6,3,1,4,7,5};
        int missing = FindMissingNumberInUnsortedArray.findMissing(input);

        assertEquals(2, missing);
    }

    @Test
    public void testFindMissingHash() throws Exception {
        int[] input = {6,3,1,4,7,5};
        int missing = FindMissingNumberInUnsortedArray.findMissingHashMap(input);

        assertEquals(2, missing);
    }
}