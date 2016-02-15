import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/13/16.
 */
public class MoveZerosToRightTest {

    @Test
    public void testMove() throws Exception {
        int[] input = {1, 0, 3, 0, 22, 4, 5};
        MoveZerosToRight.move(input);

        for (int i: input)
            System.out.print(i + " ");
    }
}