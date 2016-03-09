import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/6/16.
 */
public class StringSpaceAdjustmentTest {

    @Test
    public void testAdjust() throws Exception {
        String input = "   apple   bee  two   ";

        String expected = "apple bee two";
        String actual = StringSpaceAdjustment.adjust(input);

        assertEquals(expected, actual);
    }
}