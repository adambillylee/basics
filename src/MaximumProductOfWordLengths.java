/**
 * Created by adamli on 5/23/16.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words.length == 0)
            return 0;

        int max = 0;
        int mask[] = new int[words.length];

        // encoding masks
        for (int i = 0; i < words.length; i++) {
            char[] charArray = words[i].toCharArray();
            for (char c : charArray) {
                /**
                 * 32 bits integer has 32 pos in binary
                 * more 1 to pos that represent a char for each char
                 */
                mask[i] |= 1 << c - 'a';
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                /**
                 * use bit "and" for O(1) comparison
                 * if no char in common, all binary position will be zero
                 */
                if ((mask[i] & mask[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }

        return max;
    }
}
