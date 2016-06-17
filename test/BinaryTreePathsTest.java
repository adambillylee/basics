import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/9/16.
 */
public class BinaryTreePathsTest {
    @Test
    public void binaryTreePaths() throws Exception {
        TreeNode root = TreeUtil.getRoot(new String[]{"1","2","3"});

        List<String> rst = BinaryTreePaths.binaryTreePaths(root);

        for (String ele : rst) {
            System.out.println(ele);
        }

        root.print();
    }

}