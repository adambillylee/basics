import org.testng.annotations.Test;

/**
 * Created by adamli on 7/21/16.
 */
public class findRightMostNumberLessThanCurrentTest {
    findRightMostNumberLessThanCurrent sol = new findRightMostNumberLessThanCurrent();

    @Test
    public void testFindArray1() throws Exception {
        int[] num = {1,9,5,7};
        int[] rst = sol.findArray(num);

        for (int i : rst)
            System.out.print(i + " ");

        System.out.println();
    }

    @Test
    public void testFindArray2() throws Exception {
        int[] num = {1};
        int[] rst = sol.findArray(num);

        for (int i : rst)
            System.out.print(i + " ");

        System.out.println();
    }

    @Test
    public void testFindArray3() throws Exception {
        int[] num = {};
        int[] rst = sol.findArray(num);

        for (int i : rst)
            System.out.print(i + " ");

        System.out.println();
    }

}