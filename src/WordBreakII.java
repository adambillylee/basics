import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<>();
        // sanity check
        if (s == null || wordDict == null || wordDict.size() == 0)
            return rst;

        Map<String, List<String>> dp = new HashMap<>();

        return dfs(s, wordDict, dp);
    }

    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> dp) {
        if (dp.containsKey(s))
            return dp.get(s);

        if (s.isEmpty()) {
            List<String> rst = new ArrayList<>();
            rst.add("");
            return rst;
        }

        dp.put(s, new ArrayList<>());
        for (int i = 0; i <= s.length(); i++) {
            String curr = s.substring(i, s.length());

            if (wordDict.contains(curr)) {
                List<String> tmp = dfs(s.substring(0, i), wordDict, dp);

                for (String component : tmp) {
                    if (!component.isEmpty()) {
                        dp.get(s).add(component + " " + curr);
                    }else{
                        dp.get(s).add(curr);
                    }
                }
            }
        }

        return dp.get(s);
    }
}