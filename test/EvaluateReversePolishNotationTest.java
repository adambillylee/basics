import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/26/16.
 */
public class EvaluateReversePolishNotationTest {
    @Test
    public void evalRPN() throws Exception {
        String input[] = {"2", "1", "+", "3", "*"};
        int expected =  9;

        assertEquals(expected, EvaluateReversePolishNotation.evalRPN(input));
    }

}