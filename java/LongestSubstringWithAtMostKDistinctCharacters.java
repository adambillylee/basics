import java.util.HashMap;

/**
 * Created by adamli on 4/5/16.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i=0;
        int j=0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // outer loop, keep running after return from j loop
        while (i < s.length()) {
            /**
             * i loop, explore forward
             * stop when map of distinct char size > k
             */
            while (i < s.length() && map.size() <= k) {
                addChar(map, s.charAt(i));

                /**
                 * need to check map.size() before calculating max substring length
                 */
                if (map.size()<=k)
                    max = Math.max(max, i-j+1);

                i++;
            }
            // i at k+1th distinct char in map

            /**
             * j loop, shrink substring from start
             * stop when map of distinct char size back to k
             */
            while (j < i && map.size() > k) {
                delChar(map, s.charAt(j));
                j++;
            }
            // j at 1st distinct char in map
        }

        return max;
    }

    // add char into map
    public static void addChar(HashMap<Character, Integer> map, char c) {
        if (map.get(c) == null)
            map.put(c,1);
        else
            map.put(c, map.get(c)+1);
    }

    // del char from map
    public static void delChar(HashMap<Character, Integer> map, char c) {
        map.put(c, map.get(c)-1);

        if (map.get(c) == 0)
            map.remove(c);
    }
}
