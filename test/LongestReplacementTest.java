import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/7/16.
 */
public class LongestReplacementTest {
    LongestReplacement sol = new LongestReplacement();

    @Test
    public void findMax() throws Exception {
        System.out.println(sol.FindMax(233614));
    }


    @Test
    public void findMax1() throws Exception {
        System.out.println(sol.FindMax(10));
    }

}