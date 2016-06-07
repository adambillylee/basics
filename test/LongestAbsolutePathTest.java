import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/7/16.
 */
public class LongestAbsolutePathTest {
    LongestAbsolutePath sol = new LongestAbsolutePath();

    @Test
    public void findLongest() throws Exception {
        String input = "1\n" +
                " a.txt\n" +
                " b.txt\n" +
                "2\n" +
                " c.txt\n" +
                " 3\n" +
                "  d.txt";

        System.out.println("\\2\\3\\d.txt");
        assertEquals(10, sol.FindLongest(input));
    }

}