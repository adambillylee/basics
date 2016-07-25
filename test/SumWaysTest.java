import org.testng.annotations.Test;

/**
 * Created by adamli on 7/24/16.
 */
public class SumWaysTest {
    SumWays sol = new SumWays();

    @Test
    public void test3() throws Exception {
        sol.sumWays(3);
        System.out.println();
    }

    @Test
    public void test4() throws Exception {
        sol.sumWays(4);
        System.out.println();
    }

    @Test
    public void test5() throws Exception {
        sol.sumWays(5);
        System.out.println();
    }
}