import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 3/24/16.
 */
public class WordSearch2Test {
    WordSearch2 sol = new WordSearch2();

    @Test
    public void testFindWords() throws Exception {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "ata", "eta", "rain"};

        List<String> rst = sol.findWords(board, words);
    }

    @Test
    public void testFindWords2() throws Exception {
        char[][] board = {
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'}
        };

        String[] words = {"aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"};
        List<String> rst = sol.findWords(board, words);
    }

    @Test
    public void testFindWords3() throws Exception {
        char[][] board = {
                {'a','b'},
                {'c','d'}
        };

        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        List<String> rst = sol.findWords(board, words);
    }

    @Test
    public void testFindWords4() throws Exception {
        char[][] board = {
                {'a'}
        };

        String[] words = {"a"};
        List<String> rst = sol.findWords(board, words);
    }

    @Test
    public void testFindWords5() throws Exception {
        char[][] board = {
                {'a','b'},
                {'a','a'}
        };

        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        List<String> rst = sol.findWords(board, words);
    }

    @Test
    public void testFindWords6() throws Exception {
        String[] raw = {"seenew","tmriva","obsibd","wmysen","ltsnsa","iezlgn"};

        char[][] board = new char[raw.length][raw[0].length()];

        for (int i=0; i<raw.length;i++) {
            board[i] = raw[i].toCharArray();
        }

        String[] words = {"bend", "benda"};
        List<String> rst = sol.findWords(board, words);
    }
}