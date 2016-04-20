import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 4/18/16.
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<>();

        if (s.length() == 0 || s == null)
            return rst;

        helper(rst, new ArrayList(), s, 0);

        return rst;
    }

    private static void helper(List<List<String>> rst, List<String> list, String s, int index) {
        if (index == s.length()) {
            rst.add(new ArrayList<>(list));
            printList(list);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index, i + 1);
            if (isPalindrome(tmp)) {
                list.add(tmp);
                helper(rst, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    private static void printList(List<String> list) {
        for (String str : list)
            System.out.print(str + " ");

        System.out.println();
    }
}
