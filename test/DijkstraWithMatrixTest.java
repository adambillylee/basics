import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by adamli on 7/26/16.
 */
public class DijkstraWithMatrixTest {
    DijkstraWithMatrix sol = new DijkstraWithMatrix();

    @Test
    public void testShortestPath() throws Exception {
        int [][] map = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        List<Integer> rst =
                sol.shortestPath(map, 0, 2);

        System.out.println(rst);
    }

}