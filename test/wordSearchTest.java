import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/23/16.
 */
public class wordSearchTest {
    WordSearch sol = new WordSearch();

    @Test
    public void testExist() throws Exception {
        char[][] board = {
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'}
        };

        String word = "aaaaaaaaaaab";
        boolean actual = sol.exist(board, word);
        boolean expected = false;

        assertEquals(expected, actual);
    }
}