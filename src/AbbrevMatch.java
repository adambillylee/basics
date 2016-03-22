/**
 * Created by adamli on 3/21/16.
 */
public class AbbrevMatch {
    public static boolean isMatch(String input, String pattern) {
        if (input.length() == 0 && pattern.length() == 0)
            return true;

        // if current pattern char is letter, simply compare the letter
        if (Character.isLetter(pattern.charAt(0))) {
            if (input.charAt(0) != pattern.charAt(0))
                return false;
            else
                return isMatch(input.substring(1), pattern.substring(1));
        } else if (Character.isDigit(pattern.charAt(0))) {   // if current length is number
            int number = 0;
            // start with 0, ends at length of number (last index of number char in pattern string+ 1)
            int length = 0;

            while (Character.isDigit(pattern.charAt(length))) {
                // 1. make the number to check input string
                number = number * 10 + Character.getNumericValue(pattern.charAt(length));

                // 2. record the length to cut pattern string
                length++;
            }

            /**
             * check if remaining is long enough
             */
            if (input.length() > number) {
                /**
                 * 1. cut first "number" char from input
                 * 2. cut first "length" char from pattern
                 */
                return isMatch(input.substring(number), pattern.substring(length));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
