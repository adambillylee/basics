import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by adamli on 8/18/16.
 */
public class RateLimiterTest {
    @Test
    public void testTake() throws Exception {
        RateLimiter rateLimiter = new RateLimiter(4);

        Thread.sleep(1000L);
        for (int i=0; i<5; i++) {
            System.out.println(rateLimiter.take());
        }

        Thread.sleep(1000L);
        for (int i=0; i<5; i++) {
            System.out.println(rateLimiter.take());
        }
    }

}