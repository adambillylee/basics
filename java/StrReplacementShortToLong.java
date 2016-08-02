import java.util.ArrayList;

/**
 * Created by adamli on 3/13/16.
 */
public class StrReplacementShortToLong {
    public static String replace(String input, String shortStr, String longStr) {
        if (input == null || shortStr == null || longStr == null)
            return input;

        if (input.length() == 0 || shortStr.length() == 0 || longStr.length() == 0)
            return input;

        // find all the end index of longStrs in extended string
        ArrayList<Integer> ends = strStr(input, shortStr, longStr);

        // with all end index, replace all shortStr in input to longStr
        return replace(input, shortStr, longStr, ends);
    }

    public static ArrayList<Integer> strStr(String input, String shortStr, String longStr) {
        ArrayList<Integer> ends = new ArrayList<>();

        int indInput = 0;
        int indShort = 0;

        while (indInput + indShort < input.length()) {
            while (indShort < shortStr.length()
                    && shortStr.charAt(indShort) == input.charAt(indInput + indShort)) {
                indShort++;
            }

            /**
             * find start position of shortStr in input
             * and return all end index in final result string
             */
            if (indShort == shortStr.length()) {
                adjustStartToEnd(ends, indInput, shortStr, longStr);
            }

            indInput++;
            indShort = 0;
        }

        return ends;
    }

    /**
     * with start ind of longStr in index, get its index in extended string and add it into ends arraylist
     * @param ends  arraylist of all end index
     * @param start start index of longStr in input
     * @param shortStr  input shortStr to look for
     * @param longStr   input longStr to replace with
     * @return  all end indexes in an arraylist
     */
    public static ArrayList<Integer> adjustStartToEnd(ArrayList<Integer> ends, int start, String shortStr,
                                                      String longStr) {
        int delta = longStr.length() - shortStr.length();

        int newEnd = (start + longStr.length() - 1) // to get end from start
                + delta * ends.size();         // to adjust end position

        // add new end into ends arraylist
        ends.add(newEnd);

        return ends;
    }

    public static String replace(String input, String shortStr, String longStr,
                                 ArrayList<Integer> ends) {
        // calculate new extended char array length
        int extendedLen = input.length() +
                (longStr.length() - shortStr.length()) * ends.size();
        // create the extended char array
        char[] charArray = new char[extendedLen];

        // maintain for indexes, for extended char array, input, longStr and ends arraylist
        int indExt = extendedLen - 1;
        int indInput = input.length() - 1;
        int indLong = longStr.length() - 1;
        int indEnds = ends.size() - 1;

        // loop through all position in extended char array
        while (indExt >= 0) {
            /**
             * case 1: curr ext index is in end array
             */
            if (indEnds >= 0 && indExt == ends.get(indEnds)) {
                // fill ext char array backwards with longStr
                while (indLong >= 0) {
                    charArray[indExt--] = longStr.charAt(indLong--);
                }

                // recover longStr index
                indLong = longStr.length() - 1;

                // minus ends index by 1
                indEnds--;

                // move input index back by a shortStr length
                indInput -= shortStr.length();
            } else {
                /**
                 * case 2: curr ext index is not in ends, replacement not needed
                 * fill char array backwards by chars in input
                 */
                charArray[indExt--] = input.charAt(indInput--);
            }
        }

        return String.valueOf(charArray);
    }
}
