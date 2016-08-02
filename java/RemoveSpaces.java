/**
 * Created by adamli on 3/6/16.
 */
public class RemoveSpaces {
    /**
     * remove all leading / tail spaces
     * remove all duplicate space in middle (only keep one)
     *
     * @param input
     * @return
     */
    public static String adjust(String input) {
        if (input == null || input.length() == 0)
            return null;

        char[] charArray = input.toCharArray();

        int i = 0;
        int j = 0;
        int word_count = 0;

        /**
         * outer loop: keep running
         */
        while (true) {
            /**
             * first step: find where first char starts
             */
            while (j < charArray.length && charArray[j] == ' ')
                j++;

            // stop when j reaches the end
            if (j == charArray.length)
                break;

            /**
             * after first word (word_count>0),
             * add a space before each word
             */
            if (word_count > 0)
                charArray[i++] = ' ';

            /**
             * inside words, move char i from j
             * and keeps increasing i and j
             */
            while (j < charArray.length && charArray[j] != ' ') {
                charArray[i++] = charArray[j++];
            }

            // add word count by one after a word is went through
            word_count++;
        }

        return String.valueOf(charArray).substring(0, i);
    }
}
