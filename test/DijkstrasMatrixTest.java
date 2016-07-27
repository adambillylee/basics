import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by adamli on 7/26/16.
 */
public class DijkstrasMatrixTest {
    DijkstrasMatrix sol = new DijkstrasMatrix();

    @Test
    public void testMinPath1() throws Exception {
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

        List<Character> rst =
                sol.minPath(map, new char[]{'0','1','2','3','4','5','6','7','8'}, '0', '6');

        System.out.println(rst);
    }


    @Test
    public void testMinPath2() throws Exception {
        int [][] map = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        List<Character> rst =
                sol.minPath(map, new char[]{'A','B','C','D','E'}, 'A', 'E');

        System.out.println(rst);
    }

}