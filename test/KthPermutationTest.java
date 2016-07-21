import org.testng.annotations.Test;

/**
 * Created by adamli on 7/20/16.
 */
public class KthPermutationTest {
    KthPermutation sol = new KthPermutation();

    @Test
    public void testPermuations1() throws Exception {
        sol.getPermutation(1, 1);
    }

    @Test
    public void testPermuations2() throws Exception {
        sol.getPermutation(8, 8590);
    }
}