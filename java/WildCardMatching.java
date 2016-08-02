/**
 * Created by adamli on 5/10/16.
 */
public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        int currP = 0;
        int currS = 0;
        int startP = -1;
        int startS = -1;
        int dist = -1;

        /**
         * make sure s matches to the end when ending the loop
         */
        while (currS < s.length()) {
            /**
             * if current P char is star
             */
            if (currP < p.length() && p.charAt(currP) == '*') {
                // record start matching location of P, start matching after current start later
                startP = currP;

                // record start matching location of S
                startS = currS;

                // the matching length of current * in S, start with 0 (* matches nothing)
                dist = 0;

                // move p cursor after star
                currP++;
            } else if (isValidMatch(s, p, currP, currS)) {
                /**
                 * if its a perfect match, move both cursor forward
                 */
                currP++;
                currS++;
            } else {
                /**
                 * if current cursors doesn't match and p is not in * matching state, return false
                 */
                if (dist == -1) {
                    return false;
                } else {
                    /**
                     * if doesn't match but its in * matching state
                     * move curr p to after start
                     * move matching distance one step forward in s and restart matching
                     */
                    dist++;
                    currP = startP + 1;
                    currS = startS + dist;
                }
            }
        }

        // if s is finished and p is at *, move currP to the end of * sequence
        while (currP < p.length() && p.charAt(currP) == '*')
            currP++;

        // check if both curr are off the end
        return currP == p.length() && currS == s.length();
    }

    private boolean isValidMatch(String s, String p, int currP, int currS) {
        return currP < p.length() && (p.charAt(currP) == s.charAt(currS) || p.charAt(currP) == '?');
    }
}
