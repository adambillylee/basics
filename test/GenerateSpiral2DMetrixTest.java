import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/20/16.
 */
public class GenerateSpiral2DMetrixTest {

    @Test
    public void generateMetrixOdd() throws Exception {
        int size = 5;
        int[][] rst = new int[size][size];
        GenerateSpiral2DMetrix.generateMetrix(rst, 0, rst.length, 1);

        for (int[] row : rst) {
            for (int col : row)
                System.out.print(col + " ");

            System.out.println();
        }
    }

    @Test
    public void generateMetrixEven() throws Exception {
        int size = 4;
        int[][] rst = new int[size][size];
        GenerateSpiral2DMetrix.generateMetrix(rst, 0, rst.length, 1);

        for (int[] row : rst) {
            for (int col : row)
                System.out.print(col + " ");

            System.out.println();
        }
    }
}