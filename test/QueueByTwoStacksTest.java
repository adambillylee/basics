import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/21/16.
 */
public class QueueByTwoStacksTest {
    @Test
    public void testQueue() throws Exception{
        QueueByTwoStacks queue = new QueueByTwoStacks();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertEquals(1, queue.poll());

        queue.offer(4);

        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(4, queue.poll());
    }
}