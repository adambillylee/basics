import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 5/12/16.
 */
public class GeneratedAbbreviationTest {
    GeneratedAbbreviation sol = new GeneratedAbbreviation();

    @Test
    public void generateAbbreviations1() throws Exception {
        String input = "word";
        List<String> rst = sol.generateAbbreviations(input);

        for (String ele : rst)
            System.out.println(ele);
    }

    @Test
    public void generateAbbreviations2() throws Exception {
        String input = "dictionary";
        List<String> rst = sol.generateAbbreviations(input);

        for (String ele : rst)
            System.out.println(ele);
    }

}