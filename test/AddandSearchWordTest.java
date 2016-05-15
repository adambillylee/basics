import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/14/16.
 */
public class AddandSearchWordTest {
    AddandSearchWord sol = new AddandSearchWord();

    @Test
    public void searchWord1() throws Exception {
        sol.addWord("a");
        assertTrue(sol.search("."));
    }

    @Test
    public void searchWord2() throws Exception {
        sol.addWord("ab");
        assertTrue(sol.search("a."));
    }

}