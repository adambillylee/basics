import org.testng.annotations.Test;

/**
 * Created by adamli on 8/16/16.
 */
public class CoinsInALineTest {
    CoinsInALine sol = new CoinsInALine();

    @Test
    public void testCalculate() throws Exception {
        System.out.println(sol.calculate(new int[]{3,9,1,2}));
    }

}