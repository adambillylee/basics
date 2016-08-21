import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 8/21/16.
 */
public class PalindromeSubSequence {
    List<String> findPalindrome(String input) {
        List<String> rst = new ArrayList<>();

        if (input == null || input.isEmpty())
            return rst;

        boolean dp[][] = new boolean[input.length()][input.length()];

        // i-j=0, length = 1
        for (int i = 0; i < input.length(); i++) {
            dp[i][i] = true;
        }

        // i-j=1, length = 2
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                dp[i][i + 1] = true;
                rst.add(input.substring(i, i + 2));
            }
        }

        // i-j = 2, length = 3
        for (int len = 2; len < input.length(); len++) {
            for (int start = 0; start + len < input.length(); start++) {
                dp[start][start + len] = dp[start + 1][start + len - 1] && input.charAt(start) == input.charAt(start + len);

                if (dp[start][start + len])
                    rst.add(input.substring(start, start + len + 1));
            }
        }

        return rst;
    }
}
