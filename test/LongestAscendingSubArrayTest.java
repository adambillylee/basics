import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamlee on 2016-03-27.
 */
public class LongestAscendingSubArrayTest {

    @Test
    public void getLength() throws Exception {
        int input[] = {1,2,3,4,5,6,7};
        int actual = LongestAscendingSubArray.getLength(input);

        assertEquals(7, actual);
    }

    @Test
    public void getLength2() throws Exception {
        int input[] = {1,2,3,2,5,6,7,1};
        int actual = LongestAscendingSubArray.getLength(input);

        assertEquals(4, actual);
    }
}