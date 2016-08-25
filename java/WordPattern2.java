import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by adamli on 8/24/16.
 */
public class WordPattern2 {
    // record mapping from str to pattern cuts
    Map<String, String> mapping = new HashMap<>();

    // record all str cuts that already in mapping
    Set<String> mappedStr = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        // full mapping is found if both pattern and str are empty
        if (pattern.isEmpty())
            return str.isEmpty();

        // keep making cuts in str
        for (int i = 1; i <= str.length(); i++) {
            // make cuts in str and pattern
            String patternCut = pattern.substring(0, 1);
            String strCut = str.substring(0, i);

            // if current pattern cut already have mapping
            if (mapping.containsKey(patternCut)) {
                // keep looking for matching str cuts, keep DFS or return false
                if (mapping.get(patternCut).equals(strCut)) {
                    return wordPatternMatch(pattern.substring(1), str.substring(i));
                }else{
                    continue;
                }

            } else {
                /**
                 * if str cuts already used but pattern cut doesn't match
                 * continue searching (maybe str cut should be longer)
                 */
                if (mappedStr.contains(strCut))
                    continue;

                // DFS, add str cuts into set and mapping
                mappedStr.add(strCut);
                mapping.put(patternCut, strCut);

                // if it works, return true
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                }else {
                    // if it doesn't work, reverse changes to map and set
                    mappedStr.remove(strCut);
                    mapping.remove(patternCut);
                }
            }

        }

        return false;
    }
}
