import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by adamli on 3/1/16.
 */
public class DFS_All_Valid_ParenthesisTest {

    @Test
    public void testValid_parenthesis() throws Exception {
        int n = 3;

        List rst = DfsAllValidParenthesis.valid_parenthesis(n);

        Iterator iter = rst.iterator();

        while(iter.hasNext()) {
            Iterator innerIter = ((List)iter.next()).iterator();

            while (innerIter.hasNext()) {
                System.out.print(innerIter.next());
            }
            System.out.println();
        }
    }
}