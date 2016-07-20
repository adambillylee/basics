import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adamli on 7/19/16.
 */
public class SubmatrixSumTest {
    SubmatrixSum sol = new SubmatrixSum();

    @Test
    public void addFirst() throws Exception {
        int[][] input = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, -1}
        };

        Assert.assertEquals(2, sol.submatrixSum(input, 1, 1, 2, 2));
    }

}