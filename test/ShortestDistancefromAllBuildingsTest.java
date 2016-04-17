import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/16/16.
 */
public class ShortestDistancefromAllBuildingsTest {
    ShortestDistancefromAllBuildings sol = new ShortestDistancefromAllBuildings();

    @Test
    public void shortestDistance1() throws Exception {
        int grid[][] = {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };

        int expected = 7;

        assertEquals(expected, sol.shortestDistance(grid));
    }

    @Test
    public void shortestDistance2() throws Exception {
        int grid[][] = {
                {1,1,1,1,1,0},
                {0,0,0,0,0,1},
                {0,1,1,0,0,1},
                {1,0,0,1,0,1},
                {1,0,1,0,0,1},
                {1,0,0,0,0,1},
                {0,1,1,1,1,0}
        };

        int expected = 88;

        assertEquals(expected, sol.shortestDistance(grid));
    }
}