/**
 * Created by adamli on 8/8/16.
 */
public class LongestCommonPrefix {
    String LongestCommonPrefix(String[] list) {
        int len = Integer.MAX_VALUE;

        // get the shortest string length
        for (String str : list) {
            if (str.length() < len)
                len = str.length();
        }

        // set longest common prefix to be first string
        String rst = list[0];

        // outer loop: loop through words
        for (int i = 1; i < list.length; i++) {
            // inner loop : loop through chars in word
            for (int j = 0; j < len; j++) {
                if (list[i].charAt(j) != rst.charAt(j)) {
                    rst = rst.substring(0, j);
                }
            }
        }

        return rst;
    }
}
