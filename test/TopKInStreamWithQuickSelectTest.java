import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 8/8/16.
 */
public class TopKInStreamWithQuickSelectTest {
    TopKInStreamWithQuickSelect sol = new TopKInStreamWithQuickSelect();

    @Test
    public void testTopK() throws Exception {
        List<Integer> input = new ArrayList<>();

        for (int i = 1; i <= 1000; i++)
            input.add(i);


        System.out.println(sol.topK(input.iterator(), 3));
    }

}