import org.testng.annotations.Test;

/**
 * Created by adamli on 8/18/16.
 */
public class PerimeterTest {
    Perimeter sol = new Perimeter();

    @Test
    public void testMaxArea() throws Exception {
        int [][] input = {
                {0,0,1,0,0},
                {0,1,1,1,1},
                {0,0,1,0,0},
                {1,1,0,1,0}
        };

        System.out.println(sol.maxArea(input, 1,2));
    }

}