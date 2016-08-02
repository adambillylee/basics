import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 7/24/16.
 */
public class CountOfDigitUptoNTest {
    CountOfDigitUptoN sol = new CountOfDigitUptoN();

    @Test
    public void testCountOfDigits() throws Exception {
//        sol.countOfDigits(3);

        for (int i = 1; i<=123; i++) {
            System.out.format("%d ", i);
        }
    }
}