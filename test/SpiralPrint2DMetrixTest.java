import org.junit.Test;

/**
 * Created by adamli on 3/20/16.
 */
public class SpiralPrint2DMetrixTest {

    @Test
    public void spiralPrint() throws Exception {
        int[][] input = {
                {1,  2,  3,  4,  5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        SpiralPrint2DMetrix.spiralPrint(input, 0, input.length);
    }
}