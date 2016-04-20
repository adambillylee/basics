import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/18/16.
 */
public class PalindromePartitioningTest {
    @Test
    public void partition() throws Exception {
        String input = "aab";

        List<List<String>> rst = PalindromePartitioning.partition(input);
    }

}