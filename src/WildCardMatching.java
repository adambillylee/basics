/**
 * Created by adamli on 5/10/16.
 */
public class WildCardMatching {
    Boolean dp[][];

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        dp = new Boolean[s.length()][p.length()];

        return helper(s, p, 0, 0);
    }

    public boolean helper(String s, String p, int indS, int indP) {
        if (indP == p.length())
            return indS == s.length();

        if (indS >= s.length())
            return false;

        if (dp[indS][indP] != null)
            return dp[indS][indP].booleanValue();

        if (p.charAt(indP) != '*') {
            if (!match(s, p, indS, indP)) {
                dp[indS][indP] = new Boolean(false);
                return false;
            } else {
                return helper(s, p, indS + 1, indP + 1);
            }
        } else {
            if (helper(s, p, indS, indP + 1)) {
                dp[indS][indP] = new Boolean(true);
                return true;
            }

            int i = 1;
            while (match(s, p, indS + i, indP + 1)) {
                if (helper(s, p, indS + i, indP + 1)) {
                    dp[indS][indP] = new Boolean(true);
                    return true;
                }
                i++;
            }

            dp[indS][indP] = new Boolean(false);
            return false;
        }
    }

    private boolean match(String s, String p, int indS, int indP) {
        if (indP == p.length())
            return indS == s.length();

        if (indS >= s.length()) {
            return false;
        }

        if (p.charAt(indP) == s.charAt(indS)) {
            return true;
        }

        if (p.charAt(indP) == '?') {
            return true;
        }

        if (p.charAt(indP) == '*') {
            return true;
        }

        return false;
    }
}
