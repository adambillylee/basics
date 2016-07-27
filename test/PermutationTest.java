import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by adamli on 2/4/16.
 */
public class PermutationTest {
    Permutation sol = new Permutation();
    Permutation_with_dedup sol2 = new Permutation_with_dedup();

    @Test
    public void testPermutation() throws Exception {
        int input[] = {3,4,5,1,2};

        ArrayList<ArrayList<Integer>> rst = sol.permutation(input);

        for (int i=0; i<rst.size(); i++) {
            System.out.print("[");
            for (int j=0; j<rst.get(i).size(); j++) {
                System.out.print(rst.get(i).get(j));
            }
            System.out.println("]");
        }
    }

    @Test
    public void testPermutation_with_dedup() throws Exception {
        int input[] = {3,4,5,1,1,2};

        ArrayList<ArrayList<Integer>> rst = sol2.permutation(input);

        for (int i=0; i<rst.size(); i++) {
            System.out.print("[");
            for (int j=0; j<rst.get(i).size(); j++) {
                System.out.print(rst.get(i).get(j));
            }
            System.out.println("]");
        }
    }

    @Test
    public void testPermutation3() throws Exception {
        int input[] = {1,2,3,4};

        ArrayList<ArrayList<Integer>> rst = sol.permutation(input);

        for (int i=0; i<rst.size(); i++) {
            System.out.print("[");
            for (int j=0; j<rst.get(i).size(); j++) {
                System.out.print(rst.get(i).get(j));
            }
            System.out.println("]");
        }
    }
}