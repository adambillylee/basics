import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/27/16.
 */
public class isAnagramTest {
    isAnagram sol = new isAnagram();

    @Test
    public void isAnagram1() throws Exception {
        assertTrue(sol.isAnagram("bac", "abc"));
    }

    @Test
    public void isAnagram2() throws Exception {
        assertFalse(sol.isAnagram("bbc", "abc"));
    }

    @Test
    public void isAnagram3() throws Exception {
        assertFalse(sol.isAnagram("a", "ba"));
    }


}