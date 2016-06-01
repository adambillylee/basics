import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/31/16.
 */
public class FindMediumFromDataStreamTest {
    FindMediumFromDataStream sol = new FindMediumFromDataStream();

    @Test
    public void findMedianIncreasing() throws Exception {
        double rst[] = {1, 1.5, 2, 2.5, 3};

        for (int i = 1; i <= 5; i++) {
            sol.addNum(i);
            assertEquals(rst[i - 1], sol.findMedian(), 0.1);
        }
    }

    @Test
    public void findMedianDecreasing() throws Exception {
        double rst[] = {5, 4.5, 4, 3.5, 3};

        for (int i = 5; i >= 1; i--) {
            sol.addNum(i);
            assertEquals(rst[5 - i], sol.findMedian(), 0.1);
        }
    }

}