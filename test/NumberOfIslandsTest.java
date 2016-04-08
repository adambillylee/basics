import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/7/16.
 */
public class NumberOfIslandsTest {
    @Test
    public void numIslands() throws Exception {
        char[][] input = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','0'}
        };

        assertEquals(2, NumberOfIslands.numIslands(input));
    }

}