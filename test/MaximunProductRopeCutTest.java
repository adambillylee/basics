import org.junit.Test;
import singletonExample.MaximunProductRopeCut;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 3/29/16.
 */
public class MaximunProductRopeCutTest {

    @Test
    public void maxCutRecurrsive() throws Exception {
        assertEquals(MaximunProductRopeCut.maxCutRecurrsive(10), 36);
    }

    @Test
    public void maxCutDP() throws Exception {
        assertEquals(MaximunProductRopeCut.maxCutDP(10), 36);
    }
}