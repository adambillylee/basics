import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/15/16.
 */
public class AllAnagramsTest {

    @Test
    public void testFindAnagrames() throws Exception {
        String input = "zzzzcdebcaabcyywwww";
        String target = "aabc";
        ArrayList<String> rst = AllAnagrams.findAnagrames(input, target);

        for (String ele : rst)
            System.out.println(ele);
    }
}