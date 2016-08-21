import org.testng.annotations.Test;

/**
 * Created by adamli on 8/20/16.
 */
public class ValidSudokuTest {
    ValidSudoku sol = new ValidSudoku();

    @Test
    public void testIsValidSudoku1() throws Exception {
        String input[] = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        char board[][] = new char[input.length][input.length];

        for (int i=0; i<input.length; i++) {
            board[i] = input[i].toCharArray();
        }

        System.out.println(sol.isValidSudoku(board));
    }

    @Test
    public void testIsValidSudoku2() throws Exception {
        String input[] = {"........2","......6..","..14..8..",".........",".........","....3....","5.86.....",".9....4..","....5...."};
        char board[][] = new char[input.length][input.length];

        for (int i=0; i<input.length; i++) {
            board[i] = input[i].toCharArray();
        }

        System.out.println(sol.isValidSudoku(board));
    }

}