import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/12/16.
 */
public class DfsSubsetsTest {
    @Test
    public void subSets() throws Exception {
        int input[]= {1,2,3};
        List<List<Integer>> rst = DfsSubsets.subSets(input);

        for (List<Integer> list : rst) {
            for (int ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

}