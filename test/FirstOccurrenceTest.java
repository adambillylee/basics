import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/16/16.
 */
public class FirstOccurrenceTest {

    @Test
    public void testFirstOccurrenceFound() throws Exception {
        int input[] = {4,5,5,5,5,5};
        int target = 5;

        int expected = 1;
        int actual = FirstOccurrence.FirstOccurrence(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testFirstOccurrenceOneElement() throws Exception {
        int input[] = {5};
        int target = 5;

        int expected = 0;
        int actual = FirstOccurrence.FirstOccurrence(input, target);

        assertEquals(expected, actual);
    }

    @Test
    public void testFirstOccurrenceNotFound() throws Exception {
        int input[] = {4,2,5,6,5};
        int target = 7;

        int expected = -1;
        int actual = FirstOccurrence.FirstOccurrence(input, target);

        assertEquals(expected, actual);
    }
}