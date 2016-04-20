import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by adamli on 4/19/16.
 */
public class ZigzagIteratorTest {
    @Test
    public void testIterator() throws Exception {
        int a[] = {1, 2, 3};
        int b[] = {4, 5, 6, 7};

        ArrayList<Integer> v1 = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            v1.add(a[i]);

        ArrayList<Integer> v2 = new ArrayList<>();
        for (int i = 0; i < b.length; i++)
            v2.add(b[i]);


        ZigzagIterator sol = new ZigzagIterator(v1, v2);

        while(sol.hasNext()) {
            System.out.println(sol.next());
        }
    }
}