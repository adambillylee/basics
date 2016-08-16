import org.testng.annotations.Test;

/**
 * Created by adamli on 8/13/16.
 */
public class MatrixSpiralPrintTest {
    MatrixSpiralPrint sol = new MatrixSpiralPrint();

    @Test
    public void testPrintRandom1() throws Exception {
        int matrix[][] = {
                {1,2,3},
                {8,9,4},
                {7,6,5}
        };

        sol.printSpiralMatrix(matrix);
    }

    @Test
    public void testPrintRandom2() throws Exception {
        int matrix[][] = {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };

        sol.printSpiralMatrix(matrix);
    }

}