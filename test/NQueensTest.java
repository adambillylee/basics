import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by adamli on 3/19/16.
 */
public class NQueensTest {

    @Test
    public void eightQueens() throws Exception {
        int n = 8;
        ArrayList<int[]> rst = NQueens.NQueens(n);
        System.out.println();
    }
}