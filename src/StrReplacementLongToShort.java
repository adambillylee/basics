/**
 * Created by adamli on 3/13/16.
 * In input string, replace the longStr with shortStr
 */
public class StrReplacementLongToShort {
    /**
     * in input string, replace the target longStr with a shorter shortStr
     *
     * @param input    input string
     * @param longStr  longStr to find in input string
     * @param shortStr shortStr to replace with in input string
     * @return replaced input string
     */
    public static String replace(String input, String longStr, String shortStr) {
        if (input == null || longStr == null || shortStr == null)
            return input;

        if (input.length() == 0 || longStr.length() == 0)
            return input;

        int start = strStr(input, longStr);

        if (start == -1) {
            return input;
        } else {
            return replace(input, start, longStr, shortStr);
        }
    }

    /**
     * Find the first occurrence index of longStr in input
     *
     * @param input   input string
     * @param longStr longStr to find in input string
     * @return first index of longStr in input
     */
    public static int strStr(String input, String longStr) {
        int inputInd = 0;
        int longInd = 0;
        while (inputInd + longStr.length() < input.length()) {
            while (longInd < longStr.length() &&
                    input.charAt(inputInd + longInd) == longStr.charAt(longInd)) {
                longInd++;
            }

            if (longInd == longStr.length()) {
                return inputInd;
            }

            inputInd++;
            longInd = 0;
        }

        return -1;
    }

    /**
     * replace longStr in input with shortStr
     *
     * @param input    input string
     * @param start    starting index of longStr in input
     * @param longStr  longStr to find in input string
     * @param shortStr shortStr to replace with in input string
     * @return replaced string
     */
    public static String replace(String input, int start, String longStr, String shortStr) {
        char[] charArray = input.toCharArray();
        int end = start + longStr.length();

        /**
         * starting from start, replace input char with shortStr
         */
        for (int i = 0; i < shortStr.length(); i++) {
            charArray[start++] = shortStr.charAt(i);
        }

        /**
         * replace input char with chars after original longStr
         */
        while (end < input.length()) {
            charArray[start++] = charArray[end++];
        }

        return String.valueOf(charArray)
                .substring(0, start);
    }
}
