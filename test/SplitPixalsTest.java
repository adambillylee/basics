import org.testng.annotations.Test;

/**
 * Created by adamli on 7/10/16.
 */
public class SplitPixalsTest {
    @Test
    public void testColor() throws Exception {
        String input[] = {"101111010110011011100100", "010111011010010110000011","000000001111111111111111"};
        SplitPixals.closestColor(input);
    }

}