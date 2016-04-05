import java.util.HashMap;

public class LongestNoDupSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int i = 0;
        int j = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // outer loop: keep program from running after j loop stops
        while (i < s.length()) {
            // record char to make sure not affected by increment of i
            char c = s.charAt(i);

            // i loop: export forward
            // stop when valid condition changes
            while (i < s.length() && hasNoDup(map, c)) {
                c = s.charAt(i);
                insertMap(map, c);

                if (hasNoDup(map, c))
                    max = Math.max(max, i - j + 1);
                i++;
            }

            while (j < i && !hasNoDup(map, c)) {
                deleteMap(map, s.charAt(j));
                j++;
            }
        }

        return max;
    }

    // defines valid condition of sliding window
    public static boolean hasNoDup(HashMap<Character, Integer> map, char c) {
        if (map.get(c) == null)
            return true;
        else if (map.get(c) == 1)
            return true;
        else
            return false;
    }

    // update status of map for i
    public static void insertMap(HashMap<Character, Integer> map, char c) {
        if (map.get(c) == null)
            map.put(c, 1);
        else
            map.put(c, map.get(c) + 1);
    }

    // update status of map for j
    public static void deleteMap(HashMap<Character, Integer> map, char c) {
        map.put(c, map.get(c) - 1);

        if (map.get(c) == 0)
            map.remove(c);
    }
}