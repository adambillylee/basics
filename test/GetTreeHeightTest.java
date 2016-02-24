import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/23/16.
 */
public class GetTreeHeightTest {

    @Test
    public void testGetHeightNormal() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"1","2","3","4"});

        int expected = 3;
        int actual = GetTreeHeight.getHeight(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetHeightEmpty() throws Exception {
        TreeNode root = null;

        int expected = 0;
        int actual = GetTreeHeight.getHeight(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetHeightOnlyOne() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"1"});

        int expected = 1;
        int actual = GetTreeHeight.getHeight(root);

        assertEquals(expected, actual);
    }

}