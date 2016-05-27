import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/26/16.
 */
public class MoveZeroesTest {
    MoveZeroes sol = new MoveZeroes();

    @Test
    public void moveZeroes() throws Exception {
        int nums[] = {0,1,0,2,3};
        sol.moveZeroes(nums);
        assertArrayEquals(new int[]{1,2,3,0,0}, nums);
    }

}