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
                mask[i] |= 1 << c - 'a';
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // use mask for comparison
                if ((mask[i] & mask[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }

        return max;
    }
}
