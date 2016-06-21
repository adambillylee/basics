import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by adamli on 6/21/16.
 */
public class WordBreakIITest {
    WordBreakII sol = new WordBreakII();

    @Test
    public void test1() throws Exception {
        String s = "leetcode";
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");

        sol.wordBreak(s, set);
        System.out.println();
    }

    @Test
    public void test2() throws Exception {
        String s = "leetcode";
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("co3e");
    }


    @Test
    public void test3() throws Exception {
        String s = "catsanddog";
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");

        List<String> rst = sol.wordBreak(s, set);

        for (String tmp : rst)
            System.out.println(tmp);
    }

    @Test
    public void test4() throws Exception {
        String s = "aaaaa";
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("aa");
        set.add("aaa");
        set.add("aaaa");

        List<String> rst = sol.wordBreak(s, set);

        for (String tmp : rst)
            System.out.println(tmp);
    }


}