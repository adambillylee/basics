import org.junit.Test;

/**
 * Created by adamli on 3/17/16.
 */
public class TopKFrequentWordsInStreamTest {
    TopKFrequentWordsInStream sol = new TopKFrequentWordsInStream(2);

    @Test
    public void testPrintTopK() throws Exception {
        String[] input = {"abc", "abc", "bcec", "abbd", "bcec", "bcec", "abbd", "bcec","abc"};
        sol.printTopK(input);
    }

}