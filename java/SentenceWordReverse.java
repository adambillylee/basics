/**
 * Created by adamli on 3/10/16.
 */
public class SentenceWordReverse {
    public static String reverseSentence(String input) {
        char[] charArray = input.toCharArray();

        reverseIterative(charArray, 0, charArray.length - 1);

        int i = 0;
        int j = 0;

        while (j < charArray.length) {
            while (charArray[j] != ' ') {
                j++;

                if (j == charArray.length)
                    break;
            }

            reverseIterative(charArray, i, j-1);
            j++;
            i=j;
        }

        return String.valueOf(charArray);
    }


    public static void reverseIterative(char[] charArray, int start, int end) {
        // sanity check
        if (charArray == null || charArray.length == 0)
            return;

        int i = start;
        int j = end;

        while (i <= j) {
            swap(charArray, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] charArray, int start, int end) {
        char tmp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = tmp;
    }
}
