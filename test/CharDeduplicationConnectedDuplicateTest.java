import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/8/16.
 */
public class CharDeduplicationConnectedDuplicateTest {

    @Test
    public void testDedupe() throws Exception {
        String input = "aaabbbcccc";

        String actual = CharDeduplicationConnectedDuplicate.deduplicate(input);
        String expected = "abc";

        assertEquals(expected, actual);
    }
}