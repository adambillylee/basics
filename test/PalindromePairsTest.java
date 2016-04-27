import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 4/23/16.
 */
public class PalindromePairsTest {
    PalindromePairs sol = new PalindromePairs();

    @Test
    public void palindromePairstest1() throws Exception {
        String words[] = {"bat", "tab", "cat"};
        List<List<Integer>> rst = sol.palindromePairs(words);

        for (List<Integer> list : rst) {
            for (int tmp : list) {
                System.out.print(words[tmp]);
            }
            System.out.println();
        }
    }

    @Test
    public void palindromePairstest2() throws Exception {
        String words[] = {"abcd", "dcba", "las", "lls", "s", "sssll"};
        List<List<Integer>> rst = sol.palindromePairs(words);

        System.out.println();
        for (List<Integer> list : rst) {
            for (int tmp : list) {
                System.out.print(words[tmp]);
            }
            System.out.println();
        }
    }

    @Test
    @Ignore
    public void palindromePairstest3() throws Exception {
        String words[] = {"a", ""};
        List<List<Integer>> rst = sol.palindromePairs(words);

        System.out.println();
        for (List<Integer> list : rst) {
            for (int tmp : list) {
                System.out.print(words[tmp]);
            }
            System.out.println();
        }
    }
}