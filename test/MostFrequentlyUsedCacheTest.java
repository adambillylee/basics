import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/17/16.
 */
public class MostFrequentlyUsedCacheTest {
    MostFrequentlyUsedCache sol = new MostFrequentlyUsedCache(3);

    @Test
    public void updateOrder() throws Exception {
        MFUNode one = new MFUNode(1, 1);
        one.count = 3;

        MFUNode two = new MFUNode(2, 2);
        two.count = 2;

        MFUNode three = new MFUNode(3, 3);
        three.count = 2;

        sol.most = three;
        sol.least = one;
        three.more = null;
        three.less = two;
        two.more = three;
        two.less = one;
        one.more = two;
        one.less = null;

        sol.map.put(1, one);
        sol.map.put(2, two);
        sol.map.put(3, three);

        sol.updateOrder(1);

        assertEquals(one, sol.most);
        assertEquals(one, three.more);
        assertEquals(three, one.less);
        assertEquals(two, sol.least);
    }

    @Test
    public void setWhenCacheNotFull() throws Exception {
        MFUNode one = new MFUNode(1, 1);
        one.count = 1;

        MFUNode three = new MFUNode(3, 3);
        three.count = 3;

        sol.most = three;
        sol.least = one;
        three.less = one;
        one.more = three;

        sol.map.put(1, one);
        sol.map.put(3, three);

        sol.counts.add(2);
        sol.counts.add(3);

        sol.set(2, 2);


        assertEquals(2, one.less.key);
        assertEquals(2, sol.least.key);
    }

    @Test
    public void setWhenCacheIsFull() throws Exception {
        sol.capacity = 2;

        MFUNode two = new MFUNode(2, 2);
        two.count = 2;

        MFUNode three = new MFUNode(3, 3);
        three.count = 3;

        sol.most = three;
        sol.least = two;
        three.less = two;
        two.more = three;

        sol.map.put(2, two);
        sol.map.put(3, three);

        sol.counts.add(2);
        sol.counts.add(3);

        sol.set(1, 1);

        assertEquals(2, sol.map.size());
    }

    @Test
    public void setAndDelete() throws Exception {
        sol.capacity = 2;

        MFUNode one = new MFUNode(1, 1);
        one.count = 1;

        MFUNode two = new MFUNode(2, 2);
        two.count = 1;

        MFUNode three = new MFUNode(3, 3);
        three.count = 3;

        sol.most = three;
        sol.least = one;
        three.less = two;
        two.more = three;
        two.less = one;
        one.more = two;

        sol.map.put(1, one);
        sol.map.put(2, two);
        sol.map.put(3, three);

        sol.counts.add(1);
        sol.counts.add(3);

        sol.set(2, 2);

        assertEquals(3, sol.most.key);
        assertEquals(2, sol.least.key);
        assertEquals(two, three.less);
        assertEquals(three, two.more);
    }

    @Test
    public void setFirst() throws Exception {
        sol.capacity = 1;
        sol.set(2, 1);
        assertEquals(1, sol.get(2));
    }

    @Test
    public void setTest1() throws Exception {
        sol = new MostFrequentlyUsedCache(1);
        sol.set(2, 1);
        sol.get(2);
        sol.set(3, 2);
        assertEquals(1, sol.get(2));
        assertEquals(2, sol.get(3));
    }

}