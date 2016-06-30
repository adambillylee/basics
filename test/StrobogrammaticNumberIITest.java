import org.testng.annotations.Test;

/**
 * Created by adamli on 6/29/16.
 */
public class StrobogrammaticNumberIITest {
    StrobogrammaticNumberII sol = new StrobogrammaticNumberII();

    @Test
    public void testFindStrobogrammaticOdd() throws Exception {
        System.out.println(sol.findStrobogrammatic(3));
    }

    @Test
    public void testFindStrobogrammaticEven() throws Exception {
        System.out.println(sol.findStrobogrammatic(4));
    }

    @Test
    public void testFindStrobogrammaticOne() throws Exception {
        System.out.println(sol.findStrobogrammatic(1));
    }

}