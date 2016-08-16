import org.testng.annotations.Test;

/**
 * Created by adamli on 8/15/16.
 */
public class RestoreSpiralMatrixTest {
    RestoreSpiralMatrix sol = new RestoreSpiralMatrix();

    @Test
    public void testRestoreSpiralMatrix1() throws Exception {
        int rst[][] = sol.restoreSpiralMatrix(2, 3);

        for (int[] row : rst) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testRestoreSpiralMatrix2() throws Exception {
        int rst[][] = sol.restoreSpiralMatrix(4, 4);

        for (int[] row : rst) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testRestoreSpiralMatrix3() throws Exception {
        int rst[][] = sol.restoreSpiralMatrix(3, 3);

        for (int[] row : rst) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testRestoreSpiralMatrixOneRow() throws Exception {
        int rst[][] = sol.restoreSpiralMatrix(1, 3);

        for (int[] row : rst) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testRestoreSpiralSquare() throws Exception {
        int rst[][] = sol.generateMatrix(5);

        for (int[] row : rst) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}