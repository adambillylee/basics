import org.testng.annotations.Test;

/**
 * Created by adamli on 8/21/16.
 */
public class SudokuSolverTest {
    SudokuSolver sol = new SudokuSolver();

    @Test
    public void testSolveSudoku() throws Exception {
        String input[] = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char board[][] = new char[input.length][input.length];

        for (int i=0; i<input.length; i++) {
            board[i] = input[i].toCharArray();
        }

        sol.solveSudoku(board);

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }

}