import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class StackWithMinTest {
    @Test
    public void testEmpty() throws Exception{
        while(StackWithMin.getSize() != 0) {
            StackWithMin.pop();
        }

        assertEquals(-1, StackWithMin.min());
    }

    @Test
    public void testMin() throws Exception {
        StackWithMin.push(3);
        StackWithMin.push(6);
        StackWithMin.push(4);
        StackWithMin.push(34);
        StackWithMin.push(33);
        StackWithMin.push(6);
        StackWithMin.push(1);
        StackWithMin.push(2);

        assertEquals(1, StackWithMin.min());

        StackWithMin.pop();
        StackWithMin.pop();

        assertEquals(3, StackWithMin.min());
    }
}