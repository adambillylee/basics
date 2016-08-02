import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by adamli on 12/10/15.
 */
public class isPermutationOf {
    // sort first O(NlogN) in time, sort string take O(N) space
    public boolean isPermutationOfBySort(String a, String b) {
        // check length
        if (a.length() != b.length())
            return false;

        if (sortString(a).equals(sortString(b)))
            return true;
        else
            return false;
    }

    public String sortString(String str) {
        // sort string by char, O(N log(N))
        char chars[] = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    // O(N) for count, O(c) for space where c is the size of CharSet
    public boolean isPermutationOfByCount(String a, String b) {
        // check length
        if (a.length() != b.length())
            return false;

        // get a count of each char in charSet
        int countA[] = getCharCount(a);

        // for each char in b, minus char count in a by 1
        for (int i=0; i<b.length(); i++) {
            int c = b.charAt(i);
            countA[c]--;

            // if any char count in a < 0, that means char count of b is not identical to a, return false
            if (countA[c]<0)
                return false;
        }

        return true;
    }

    public int[] getCharCount(String a) {
        // assuming a is in CharSet ASCII, which has 128 chars
        int rst[] = new int[128];

        for (int i=0; i<a.length(); i++) {
            int c = a.charAt(i);
            rst[c]++;
        }

        return rst;
    }
}
