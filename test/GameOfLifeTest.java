import org.junit.Test;

/**
 * Created by adamli on 5/31/16.
 */
public class GameOfLifeTest {
    GameOfLife sol = new GameOfLife();

    @Test
    public void gameOfLife1() throws Exception {
        int[][] board = {{1}};
        sol.gameOfLife(board);

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void gameOfLife2() throws Exception {
        int[][] board = {{1, 1}};
        sol.gameOfLife(board);

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void gameOfLife3() throws Exception {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        sol.gameOfLife(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}