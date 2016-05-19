import org.junit.Test;

/**
 * Created by adamli on 5/19/16.
 */
public class SortColorsTest {
    SortColors sol = new SortColors();

    @Test
    public void sortColors() throws Exception {
        int nums[] = {0, 1, 2, 1, 0, 1, 2, 0, 1, 2};
        sol.sortColors(nums);

        for (int num: nums)
            System.out.println(num);
    }

}