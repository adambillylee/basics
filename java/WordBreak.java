import java.util.Set;

/**
 * Created by adamli on 4/2/16.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        /**
         * m represent from cut position 0~i, can s be divided into dict words
         * cut position index = string index + 1;
         */
        boolean[] m = new boolean[s.length() + 1];
        m[0] = true;

        /**
         * BUG POINT:
         * cut position = string index + 1
         */
        for (int i = 1; i <= s.length(); i++) {
            /**
             * Optimization:
             * j going backward from i-1, will reach a bigger m[j] true value quicker
             */
            for (int j = i-1; j >=0; j--) {

                /**
                 * BUG POINT:
                 * cut position = string index + 1
                 */
                String partial = s.substring(j, i);

                /**
                 * if we cut at position j, before j is in dict
                 * than if j~i is in dict, i is in dict
                 */
                if (m[j] && wordDict.contains(partial)) {
                    m[i] = true;
                    break;
                }
            }
        }

        return m[s.length()];
    }
}
