import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by adamli on 5/21/16.
 */
public class SkylineTest {
    Skyline sol = new Skyline();

    @Test
    public void getSkyline() throws Exception {
        int buildings[][] = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        List<int []> exptected = Arrays.asList(
                new int[]{2,10},
                new int[]{3,15},
                new int[]{7,12},
                new int[]{12,0},
                new int[]{15,10},
                new int[]{20,8},
                new int[]{24,0});

        List<int []> actual = sol.getSkyline(buildings);

        for (int i=0; i<exptected.size(); i++) {
            assertArrayEquals(exptected.get(i), actual.get(i));
        }
    }

    @Test
    public void getSkylineConnectedSameHeight() throws Exception {
        int buildings[][] = {{0,2,3}, {2,5,3}};
        List<int []> exptected = Arrays.asList(
                new int[]{0,3},
                new int[]{5,0}
        );

        List<int []> actual = sol.getSkyline(buildings);

        for (int i=0; i<exptected.size(); i++) {
            assertArrayEquals(exptected.get(i), actual.get(i));
        }
    }

}