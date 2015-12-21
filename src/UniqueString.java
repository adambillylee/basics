import java.util.Arrays;

/**
 * Created by adamli on 12/10/15.
 */
public class UniqueString {
    // O(N log(N)) in total
    public boolean isUniqueString(String str) {
        str = sortString(str);

        // Go through string, O(N)
        for (int i=1; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i-1))
                return false;
        }

        return true;
    }

    private String sortString(String str) {
        // sort string by char, O(N log(N))
        char chars[] = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

}
