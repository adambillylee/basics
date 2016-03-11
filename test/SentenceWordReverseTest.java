import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/10/16.
 */
public class SentenceWordReverseTest {

    @Test
    public void testReverseSentence() throws Exception {
        String input = "Iabc love Yahoo";
        String actual = SentenceWordReverse.reverseSentence(input);
        String expected = "Yahoo love Iabc";

        assertEquals(expected, actual);
    }
}