import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 5/3/16.
 */
public class RemoveDupLettersAndKeepOrderTest {
    RemoveDupLettersAndKeepOrder sol = new RemoveDupLettersAndKeepOrder();

    @Test
    public void removeDuplicateLetters1() throws Exception {
        String input = "bcabc";
        System.out.println(input);
        System.out.println(sol.removeDuplicateLetters(input));
    }

    @Test
    public void removeDuplicateLetters2() throws Exception {
        String input = "cbacdcbc";
        System.out.println(input);
        System.out.println(sol.removeDuplicateLetters(input));
    }

    @Test
    public void removeDuplicateLetters3() throws Exception {
        String input = "bbcaac";
        System.out.println(input);
        System.out.println(sol.removeDuplicateLetters(input));
    }
}