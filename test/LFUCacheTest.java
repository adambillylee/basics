import org.testng.annotations.Test;

/**
 * Created by adamli on 8/9/16.
 */
public class LFUCacheTest {
    LFUCache sol = new LFUCache(3);

    @Test
    public void testPut() throws Exception {
        sol.put(1,1);
        sol.put(1,1);
        sol.put(1,1);
        sol.put(1,1);
        sol.put(2,2);
        sol.put(2,2);
        sol.put(2,2);
        sol.put(3,3);
        sol.put(3,3);
        sol.put(4,4);
        sol.put(5,5);


        System.out.println(sol.getMax());
        System.out.println(sol.getMin());
    }
}