import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/12/16.
 */
public class Rand21ToRand7Test {
    @Test
    public void rand7() throws Exception {
        for (int i=0; i<50; i++)
            System.out.println(Rand21ToRand7.rand7());
    }

}