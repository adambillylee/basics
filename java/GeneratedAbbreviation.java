import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 5/12/16.
 */
public class GeneratedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<>();

        if (word.length() == 0) {
            rst.add("");
            return rst;
        }

        helper(rst, word, 0, new StringBuilder(), false);

        return rst;
    }

    private void helper(List<String> rst, String word, int start, StringBuilder sb, boolean prevNum) {
        if (start == word.length()) {
            rst.add(sb.toString());
            return;
        }

        int len = sb.length();

        /**
         * loop from current start to end of word
         */
        for (int i = start; i < word.length(); i++) {
            /**
             * if this is the first iteration of this start, we can choose to add char into word
             */
            if (i == start) {
                helper(rst, word, i + 1, sb.append(word.charAt(i)), false);
                sb.setLength(len);
            }

            /**
             * if previous position is not a number, we can choose to add number into word
             * number depends on start and current i
             */
            if (!prevNum) {
                helper(rst, word, i + 1, sb.append(getNumberString(start, i)), true);
                sb.setLength(len);
            }
        }
    }

    private String getNumberString(int start, int end) {
        // if start == end, the number is 1
        return Integer.toString(end - start + 1);
    }
}
