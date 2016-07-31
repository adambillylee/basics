import org.testng.annotations.Test;

/**
 * Created by adamli on 7/27/16.
 */
public class NextPermutationTest {
    NextPermutation sol = new NextPermutation();

    @Test
    public void nextPermutation() {
        System.out.println(sol.getPermutation(3, 5));
    }

}