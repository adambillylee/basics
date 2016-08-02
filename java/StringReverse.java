/**
 * Created by adamli on 3/10/16.
 */
public class StringReverse {
    public static String reverseRecursive(String input) {
        // sanity check
        if (input == null || input.length() == 0)
            return "";

        char[] charArray = input.toCharArray();

        helper(charArray, 0, charArray.length - 1);

        return String.valueOf(charArray);
    }

    public static void helper(char[] charArray, int start, int end) {
        if (start > end) {
            return;
        }

        swap(charArray, start, end);
        helper(charArray, start + 1, end - 1);
    }

    private static void swap(char[] charArray, int start, int end) {
        char tmp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = tmp;
    }

    public static String reverseIterative(String input) {
        // sanity check
        if (input == null || input.length() == 0)
            return "";

        char[] charArray = input.toCharArray();

        int i = 0;
        int j = charArray.length-1;

        while (i <= j) {
            swap(charArray, i, j);
            i++;
            j--;
        }

        return String.valueOf(charArray);
    }
}
