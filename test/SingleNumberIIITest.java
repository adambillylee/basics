import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/27/16.
 */
public class SingleNumberIIITest {
    SingleNumberIII sol  = new SingleNumberIII();

    @Test
    public void singleNumber() throws Exception {
        int input[] = {1,1,2,2,3,5};
        assertArrayEquals(new int[]{3,5}, sol.singleNumber(input));
    }

}