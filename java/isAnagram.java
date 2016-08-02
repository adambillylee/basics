import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamli on 5/27/16.
 */
public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        for (char c: t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);

                if (map.get(c) == 0)
                    map.remove(c);
            }else{
                return false;
            }
        }

        return map.size() == 0;
    }
}
