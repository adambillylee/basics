import org.testng.annotations.Test;

/**
 * Created by adamli on 8/10/16.
 */
public class findDupsInArrayTest {
    findDupsInArray sol = new findDupsInArray();

    @Test
    public void testFindDups1() throws Exception {
        int input[] = {1,1,2,2,3,3,4,5,6,6,7};
        System.out.println(sol.findDups(input));
    }

    @Test
    public void testFindDups2() throws Exception {
        int input[] = {};
        System.out.println(sol.findDups(input));
    }

    @Test
    public void testFindDups3() throws Exception {
        int input[] = {1,2,3,4,5,6};
        System.out.println(sol.findDups(input));
    }

}