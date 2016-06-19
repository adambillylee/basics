import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/19/16.
 */
public class FriendsCircleTest {
    FriendsCircle sol = new FriendsCircle();

    @Test
    public void findCircle1() throws Exception {
        String friends[] = {
                "YYNN",
                "YYYN",
                "NYYN",
                "NNNY"
        };
        assertEquals(2, sol.findCircle(friends));
    }

    @Test
    public void findCircle2() throws Exception {
        String friends[] = {"Y"};
        assertEquals(1, sol.findCircle(friends));
    }
    @Test
    public void findCircle3() throws Exception {
        String friends[] = {
                "YNNNN",
                "NYNNN",
                "NNYNN",
                "NNNYN",
                "NNNNY"
        };
        assertEquals(5, sol.findCircle(friends));
    }

}