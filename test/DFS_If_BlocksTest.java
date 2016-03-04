import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/3/16.
 */
public class DFS_If_BlocksTest {

    @Test
    public void testIf_blocksEven() throws Exception {
        DFS_If_Blocks.if_blocks(5);
    }

    @Test
    public void testIf_blocksOdd() throws Exception {
        DFS_If_Blocks.if_blocks(4);
    }
}