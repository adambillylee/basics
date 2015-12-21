import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by adamli on 12/10/15.
 */
public class UniqueStringTest {
    UniqueString sol = new UniqueString();

    @Test
    public void testIsUniqueString() throws Exception {
        String unique = "abcde";
        String notUnique = "abdca";

        assertTrue("unique string test failed", sol.isUniqueString(unique));
        assertFalse("not unique string test failed", sol.isUniqueString(notUnique));
    }
}