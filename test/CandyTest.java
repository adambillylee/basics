import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/3/16.
 */
public class CandyTest {
    Candy sol = new Candy();

    @Test
    public void candy() throws Exception {
        int input[] = {1,2,3,2,1};
        assertEquals(9, sol.candy(input));
    }

}