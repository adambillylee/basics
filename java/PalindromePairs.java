import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adamli on 4/23/16.
 */
public class PalindromePairs {
    String[] words;

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new ArrayList<>();

        this.words = words;

        if (words == null || words.length == 0)
            return rst;

        /**
         * make a reverse index
         */
        Map<String, Integer> reversedIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reversedIndex.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            /**
             * cut though all positions in words[i]
             * all the way up to j = words[i].length(), to get to emtpy string corner case
             */
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);

                if (isPalindrome(left)) {
                    String reverse = new StringBuilder(right).reverse().toString();
                    if (reversedIndex.containsKey(reverse) && reversedIndex.get(reverse) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(reversedIndex.get(reverse));
                        list.add(i);
                        rst.add(list);
                    }
                }

                if (isPalindrome(right)) {
                    String reverse = new StringBuilder(left).reverse().toString();
                    if (reversedIndex.containsKey(reverse) && reversedIndex.get(reverse) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(reversedIndex.get(reverse));
                        list.add(i);
                        rst.add(list);
                    }
                }
            }
        }

        return rst;
    }

    boolean isPalindrome(String input) {
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
}
