import org.junit.Test;

/**
 * Created by adamli on 6/5/16.
 */
public class IntegerToEnglishTest {
    IntegerToEnglish sol = new IntegerToEnglish();

    @Test
    public void helper1() throws Exception {
        System.out.println(sol.helper(123));
    }

    @Test
    public void helper() throws Exception {
        System.out.println(sol.helper(998));
    }

    @Test
    public void numberToWords1() throws Exception {
        System.out.println(sol.numberToWords(1990));
    }

    @Test
    public void numberToWords2() throws Exception {
        System.out.println(sol.numberToWords(1111990));
    }

    @Test
    public void numberToWords3() throws Exception {
        System.out.println(sol.numberToWords(1234567));
    }

    @Test
    public void numberToWords4() throws Exception {
        System.out.println(sol.numberToWords(1000));
    }

    @Test
    public void numberToWords5() throws Exception {
        System.out.println(sol.numberToWords(1000000));
    }

    @Test
    public void numberToWords6() throws Exception {
        System.out.println(sol.numberToWords(110000));
    }
}