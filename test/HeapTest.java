import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 7/6/16.
 */
public class HeapTest {
    Heap sol = new Heap(3);

    @Test
    public void testInsert() throws Exception {
        sol.insert(3);
        Assert.assertArrayEquals(new int[]{3, 0, 0}, sol.arr);
        sol.insert(2);
        Assert.assertArrayEquals(new int[]{2, 3, 0}, sol.arr);
        sol.insert(1);
        Assert.assertArrayEquals(new int[]{1, 3, 2}, sol.arr);
    }

    @Test
    public void testPop() throws Exception {
        sol = new Heap(3);
        sol.insert(3);
        sol.insert(1);
        sol.insert(2);

        Assert.assertEquals(1, sol.pop());
        Assert.assertEquals(2, sol.pop());
        Assert.assertEquals(3, sol.pop());
    }

    @Test
    public void testAll() throws Exception {

        sol = new Heap(6);
        sol.insert(3);
        sol.insert(5);
        sol.insert(6);
        sol.insert(1);
        sol.insert(2);
        sol.insert(4);

        Assert.assertEquals(1, sol.pop());
        Assert.assertEquals(2, sol.pop());
        Assert.assertEquals(3, sol.pop());
        Assert.assertEquals(4, sol.pop());
        Assert.assertEquals(5, sol.pop());
        Assert.assertEquals(6, sol.pop());
        Assert.assertEquals(0, sol.size);
    }

}