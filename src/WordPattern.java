import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamlee on 2016-05-30.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = str.split(" ");

        if (pattern.length() != arr.length)
            return false;

        /**
         * loop through pattern and word together
         * matching pairs: a char in pattern => a word in str
         */
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = arr[i];

            if (!map.containsKey(c)) {
                /**
                 * if current word is assigned to another char in pattern, return false
                 */
                if (map.containsValue(word))
                    return false;

                map.put(c, word);
            } else {
                /**
                 * if word corresponding to c is not equal to current word, return false
                 */
                if (!map.get(c).equals(word))
                    return false;
            }
        }

        return true;
    }
}
