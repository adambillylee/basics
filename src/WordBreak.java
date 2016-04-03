import java.util.Set;

/**
 * Created by adamli on 4/2/16.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        /**
         * m represent from cut position 0~i, can s be divided into dict words
         */
        boolean[] m = new boolean[s.length() + 1];
        m[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String partial = s.substring(j, i);

                if (m[j] && wordDict.contains(partial)) {
                    m[i] = true;
                    break;
                }
            }
        }

        return m[s.length()];
    }
}
