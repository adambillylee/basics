/**
 * Created by adamli on 8/17/16.
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int i = 0;
        int j = 0;
        int targetMap[] = new int[128];
        int currMap[] = new int[128];
        String min = "";
        StringBuilder curr = new StringBuilder();

        for (char c : t.toCharArray()) {
            targetMap[c - 'A']++;
        }

        while (j < s.length()) {
            while (j < s.length() && !covers(currMap, targetMap)) {
                currMap[s.charAt(j) - 'A']++;
                curr.append(s.charAt(j));
                j++;
            }

            while (i < j && covers(currMap, targetMap)) {
                if (covers(currMap, targetMap))
                    min = update(min, curr);

                currMap[s.charAt(i) - 'A']--;
                curr = curr.deleteCharAt(0);

                i++;
            }
        }

        return min;
    }

    private String update(String min, StringBuilder curr) {
        if (curr.length() < min.length() || min.isEmpty())
            min = curr.toString();

        return min;
    }

    private boolean covers(int currMap[], int targetMap[]) {
        for (int i = 0; i < currMap.length; i++) {
            if (targetMap[i] > currMap[i])
                return false;
        }

        return true;
    }
}
