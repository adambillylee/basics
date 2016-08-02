import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamli on 6/29/16.
 */
public class ValidRoman {
    Map<String, Integer> dict = new HashMap();

    void setup() {
        dict.put("M", 1000);
        dict.put("CM", 900);
        dict.put("D", 500);
        dict.put("CD", 400);
        dict.put("C", 100);
        dict.put("XC", 90);
        dict.put("L", 50);
        dict.put("XL", 40);
        dict.put("X", 10);
        dict.put("IX", 9);
        dict.put("V", 5);
        dict.put("IV", 4);
        dict.put("I", 1);
    }

    public boolean isValidRoman(String s) {
        if (s == null || s.length() == 0)
            return false;

        setup();
        return dfs(s, 1000);
    }

    boolean dfs(String romanStr, int prev) {
        if (romanStr.length() == 0) {
            return true;
        }

        if (romanStr.length() == 1) {
            return isValidStr(romanStr.substring(0, 1), prev);
        }

        if (romanStr.length() == 2) {
            if (isValidStr(romanStr.substring(0, 2), prev))
                return true;
        }

        if (isValidStr(romanStr.substring(0, 1), prev)) {
            String currStr = romanStr.substring(0, 1);
            int currValue = dict.get(currStr);

            String nextStr = romanStr.substring(1, 2);

            if (!dict.containsKey(nextStr))
                return false;
            else {
                int nextValue = dict.get(nextStr);
                if (hasValidNextValue(prev, currValue, nextValue)) {
                    if (dfs(romanStr.substring(1), currValue))
                        return true;
                }
            }
        }

        if (romanStr.length() >= 2 && isValidStr(romanStr.substring(0, 2), prev)) {
            String currStr = romanStr.substring(0, 1);
            int currValue = dict.get(currStr);

            if (currValue < prev) {
                return dfs(romanStr.substring(2), currValue);
            }
        }

        return false;
    }

    private boolean hasValidNextValue(int prev, int currValue, int nextValue) {
        if (isPowerOfTen(currValue)) {
            return nextValue == currValue * 5 || nextValue == currValue * 10 || currValue <= prev;
        } else {
            return currValue < prev;
        }
    }

    private boolean isValidStr(String substring, int prev) {
        if (!dict.containsKey(substring))
            return false;

        int val = dict.get(substring);

        if (isPowerOfTen(val))
            return prev >= val;
        else
            return prev > val;
    }

    boolean isPowerOfTen(int n) {
        if (n > 1)
            while (n % 10 == 0) n /= 10;
        return n == 1;
    }

}