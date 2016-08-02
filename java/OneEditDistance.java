/**
 * Created by adamli on 5/10/16.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length())
            return replace(s,t);
        else if (s.length() == t.length()-1) {
            return add(s,t);
        }else if (s.length() == t.length()+1) {
            return add(t,s);
        }else{
            return false;
        }
    }

    private boolean replace(String s, String t) {
        boolean foundDiff = false;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (!foundDiff)
                    foundDiff = true;
                else
                    return false;
            }
        }

        return foundDiff;
    }

    private boolean add(String s, String l) {
        int i = 0;
        for (; i<s.length(); i++) {
            if (s.charAt(i) != l.charAt(i)) {
                break;
            }
        }

        return s.substring(i).equals(l.substring(i+1));
    }
}
