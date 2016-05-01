import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/30/16.
 */
public class ReverseWordsinaStringTest {
    @Test
    public void reverseWords() throws Exception {
        String actual = ReverseWordsinaString.reverseWords("   a   b ");
        assertEquals("b a", actual);
    }

}