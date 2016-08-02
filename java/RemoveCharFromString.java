import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * Created by adamli on 3/6/16.
 */
public class RemoveCharFromString {
    public static String removeChar(String input, char[] toRemove) {
        if (input == null || input.length() == 0) {
            return null;
        }

        if (toRemove == null || toRemove.length == 0)
            return input;

        /**
         * [0~i) all char with target removed
         * [i~j) chars to delete
         * [j~end] unknown to explore
         */
        int i = 0;
        int j = 0;

        char[] charArray = input.toCharArray();

        /**
         * loop through each char to remove
         */
        while(j < charArray.length) {
            boolean foundToRemove = false;
            char curr = charArray[j];

            // check all chars in to remove, if found, mark flag to be true
            for (char k: toRemove) {
                if (k == curr) {
                    foundToRemove = true;
                    break;
                }
            }

            /**
             * move char array[i] from j, if toRemove chars are not found
             */
            if (!foundToRemove) {
                charArray[i] = charArray[j];
                i++;
            }

            j++;
        }

        return String.valueOf(charArray).substring(0,i);
    }
}
