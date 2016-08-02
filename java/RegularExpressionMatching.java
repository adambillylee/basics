/**
 * Created by adamli on 5/8/16.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int indS, int indP) {
        if (indP == p.length())
            return indS == s.length();

        if (indP + 1 >= p.length() || p.charAt(indP + 1) != '*') {
            if (!matchFirst(s, p, indS, indP))
                return false;
            else
                return helper(s, p, indS + 1, indP + 1);
        } else {

            if (helper(s, p, indS, indP + 2))
                return true;

            while (matchFirst(s, p, indS, indP)) {
                if (helper(s, p, ++indS, indP + 2))
                    return true;
            }

            return false;
        }
    }

    private boolean matchFirst(String s, String p, int indS, int indP) {
        if (indS >= s.length())
            return false;

        return (s.charAt(indS) == p.charAt(indP)) || (p.charAt(indP) == '.');
    }
}
