import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adamli on 8/15/16.
 */
public class LetterCombinationOfPhoneNumber {
    Map<Character, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        // populate mappings
        populateMap();

        List<String> rst = new ArrayList<>();
        dfs(rst, "", digits);
        return rst;
    }

    private void dfs(List<String> rst, String list, String digits) {
        if (digits.isEmpty()) {
            if (!list.isEmpty())
                rst.add(list);

            return;
        }

        Character curr = digits.charAt(0);
        for (char c : map.get(curr)) {
            dfs(rst, list + c, digits.substring(1, digits.length()));
        }
    }

    private void populateMap() {
        map.put('2', "abc".toCharArray());
        map.put('3', "def".toCharArray());
        map.put('4', "ghi".toCharArray());
        map.put('5', "jkl".toCharArray());
        map.put('6', "mno".toCharArray());
        map.put('7', "pqrs".toCharArray());
        map.put('8', "tuv".toCharArray());
        map.put('9', "wxyz".toCharArray());
        map.put('*', "+".toCharArray());
        map.put('0', " ".toCharArray());
    }
}
