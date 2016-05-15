import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/14/16.
 */
public class TicTacToeO1Test {
    TicTacToeO1 sol = new TicTacToeO1(3);

    @Test
    public void move() throws Exception {
        System.out.println(sol.move(0,0,1));
        System.out.println(sol.move(0,2,2));
        System.out.println(sol.move(2,2,1));
        System.out.println(sol.move(1,1,2));
        System.out.println(sol.move(2,0,1));
        System.out.println(sol.move(1,0,2));
        System.out.println(sol.move(2,1,1));
    }

}