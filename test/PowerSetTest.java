import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/5/16.
 */
public class PowerSetTest {
    PowerSet sol = new PowerSet();

    @Test
    public void testPowerSet() throws Exception {
        int input[] = {0,1,2};
        ArrayList<ArrayList<Integer>> rst = PowerSet.powerSet(input);

        for (int i=0; i<rst.size(); i++) {
            System.out.print("[");
            for (int j=0; j<rst.get(i).size(); j++) {
                System.out.print(rst.get(i).get(j));
            }
            System.out.println("]");
        }
    }
}