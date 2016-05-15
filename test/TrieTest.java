import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/14/16.
 */
public class TrieTest {
    Trie sol = new Trie();

    @Test
    public void insertTest() throws Exception {
        sol.insert("ab");
        sol.search("a");
        sol.startsWith("a");
    }

}