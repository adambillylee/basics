import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/12/16.
 */
public class Rand5ToRand25Test {
    @Test
    public void rand25() throws Exception {
        for (int i=0; i<50; i++)
            System.out.println(Rand5ToRand25.rand25());
    }

}