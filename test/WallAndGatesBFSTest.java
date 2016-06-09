import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/9/16.
 */
public class WallAndGatesBFSTest {
    WallAndGatesBFS sol = new WallAndGatesBFS();

    @Test
    public void wallsAndGates() throws Exception {
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        sol.wallsAndGates(rooms);

        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                System.out.print(rooms[i][j] + "\t");
            }
            System.out.println();
        }
    }

}