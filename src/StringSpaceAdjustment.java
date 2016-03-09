/**
 * Created by adamli on 3/6/16.
 */
public class StringSpaceAdjustment {
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

        int j=0;
        int i=0;
        int word_count = 0;

        while(true) {

            while(j<charArray.length && charArray[j] == ' ')
                j++;

            if (j==charArray.length)
                break;

            if (word_count>0)
                charArray[i++] = ' ';

            while(charArray[j] != ' ' && j<charArray.length) {
                charArray[i++] = charArray[j++];
            }

            word_count++;
        }

        return String.valueOf(charArray)
                .substring(0,i);
    }
}
