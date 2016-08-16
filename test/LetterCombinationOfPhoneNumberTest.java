import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by adamli on 8/15/16.
 */
public class LetterCombinationOfPhoneNumberTest {
    LetterCombinationOfPhoneNumber sol = new LetterCombinationOfPhoneNumber();

    @Test
    public void testLetterCombinations() throws Exception {
        List<String> rst = sol.letterCombinations("23");

        System.out.println(rst);
    }

}