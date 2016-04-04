import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/4/16.
 */
public class EditDistanceTest {
    @Test
    public void minDistance2D() throws Exception {
        // delete 1
        assertEquals(1, EditDistance.minDistance("abc","ab"));

        // insert 1
        assertEquals(1, EditDistance.minDistance("ab","abc"));

        // replace 1
        assertEquals(1, EditDistance.minDistance("abd","abc"));

        // empty
        assertEquals(0, EditDistance.minDistance("",""));

        // one char match
        assertEquals(1, EditDistance.minDistance("a","ab"));

        // one char, doens't match
        assertEquals(2, EditDistance.minDistance("c","ab"));
    }

}