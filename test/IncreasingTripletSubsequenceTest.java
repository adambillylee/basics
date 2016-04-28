import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/27/16.
 */
public class IncreasingTripletSubsequenceTest {
    @Test
    public void increasingTriplet1() throws Exception {
        int input[] = {1,0,0,3,0,0,2,-1,-1,4};
        assertTrue(IncreasingTripletSubsequence.increasingTriplet(input));
    }

    @Test
    public void increasingTriplet2() throws Exception {
        int input[] = {50,10,9,8,20,9,8,30,9};
        assertTrue(IncreasingTripletSubsequence.increasingTriplet(input));
    }

}