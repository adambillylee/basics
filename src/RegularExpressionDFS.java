/**
 * Created by adamli on 6/21/16.
 */
public class RegularExpressionDFS {
    public boolean isMatch(String s, String p) {
        return helper(p, s);
    }

    private boolean helper(String p, String s) {
        if (p.isEmpty() && s.isEmpty()) {
            return true;
        }

        /**
         * s = ""
         * p = "*c*c"
         */
        if (hasStar(p) && s.isEmpty()) {
            return helper(p.substring(2), s);
        }

        if (p.isEmpty()) {
            return false;
        }

        if (s.isEmpty()) {
            return false;
        }

        if (hasStar(p)) {
            /**
             * when star match nothing
             */
            if (helper(p.substring(2), s))
                return true;
            else {
                /**
                 * when star match at least one char in s
                 */
                while (!s.isEmpty() && matchHead(p, s)) {
                    /**
                     * BUG POINT: remove current matching first char in s
                     */
                    if (helper(p.substring(2), s.substring(1)))
                        return true;
                    else
                        s = s.substring(1);
                }
            }
        } else {
            if (matchHead(p, s))
                return helper(p.substring(1), s.substring(1));
        }

        return false;
    }

    /**
     * is current p head a star pattern? (.* or a*, etc)
     * @param p
     * @return true or false
     */
    private boolean hasStar(String p) {
        return p.length() >= 2 && p.charAt(1) == '*';
    }

    /**
     * does the first char in s and p match?
     * @param p
     * @param s
     * @return true or false
     */
    private boolean matchHead(String p, String s) {
        if (s.charAt(0) == p.charAt(0))
            return true;

        if (p.charAt(0) == '.')
            return true;

        return false;
    }
}
