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
        while (j < charArray.length) {
            char curr = charArray[j];

            // mark boolean flag if to remove char is found
            boolean foundCharToRemove = false;
            for (int k = 0; k < toRemove.length; k++) {
                if (curr == toRemove[k]) {
                    foundCharToRemove = true;
                    break;
                }
            }

            // if to remove char is not found, move i forward and replace char i with char j
            if (!foundCharToRemove) {
                charArray[i] = charArray[j];
                i++;
            }

            // if to remove char is found, i will not move

            // always move j forward search for new char in input string
            j++;
        }


        return String.valueOf(charArray)
                .substring(0,i);
    }
}
