/**
 * Created by adamli on 3/12/16.
 */
public class Strstr {
    public static int strStr(String longStr, String shortStr) {
        if (longStr == null || shortStr == null)
            return -1;

        int longInd = 0;
        int shortInd = 0;

        /**
         * outer loop: stop when longInd + shortStr length > longStr length
         */
        while (longInd + shortStr.length() < longStr.length()) {
            /**
             * remember to put shortInd < shortStr.length() in the front
             * need to check if char from short is out of bound
             */
            while (shortInd < shortStr.length() &&
                    longStr.charAt(longInd + shortInd) == shortStr.charAt(shortInd)) {
                shortInd++;
            }

            if (shortInd - longInd + 1 == shortStr.length())
                return longInd;

            longInd++;
            shortInd = 0;
        }

        return -1;
    }
}
