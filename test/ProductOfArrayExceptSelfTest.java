import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/27/16.
 */
public class ProductOfArrayExceptSelfTest {
    ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();

    @Test
    public void productExceptSelf() throws Exception {
        int input[] = {1,2,3,4};
        assertArrayEquals(new int[]{24, 12, 8, 6}, sol.productExceptSelf(input));
    }

}