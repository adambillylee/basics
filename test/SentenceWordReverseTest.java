import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/10/16.
 */
public class SentenceWordReverseTest {

    @Test
    public void testReverseSentence() throws Exception {
        String input = "I love Yahoo";
        String actual = SentenceWordReverse.reverseSentence(input);
        String expected = "Yahoo love I";

        assertEquals(expected, actual);
    }
}