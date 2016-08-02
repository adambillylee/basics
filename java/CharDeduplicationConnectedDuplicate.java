/**
 * Created by adamli on 3/8/16.
 */
public class CharDeduplicationConnectedDuplicate {
    /**
     * de-duplicate a string where all duplicate chars are connected
     * @param input string like "aaabbbccc"
     * @return  deduped string like "abc"
     */
    public static String deduplicate(String input) {
        if (input == null || input.length() == 0)
            return "";

        /**
         * [0~i) represent all deduped area
         * [i~j) area with duplication (to delete)
         * [j~end] unknown
         */
        int i = 0;
        int j = 0;

        char[] charArray = input.toCharArray();

        while (j < charArray.length) {
            if (charArray[i] != charArray[j]) {
                charArray[++i] = charArray[j];
            }

            j++;
        }

        /**
         * i is sitting at last deduped char now
         * according to definition, charArray[i] should not be included in deduped area
         * need to move i forward by 1, allowing it to stick to our definition
         */
        i++;

        return String.valueOf(charArray)
                .substring(0, i);
    }
}
