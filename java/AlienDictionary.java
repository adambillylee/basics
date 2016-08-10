import java.util.*;

public class AlienDictionary {
    private boolean to[][] = new boolean[26][26];
    private int outDegree[] = new int[26];
    private Set<Character> alphabets = new HashSet<>();
    // private Set<Character> visited = new HashSet<>();

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";

        if (!buildGraph(words))
            return "";

        return topoSort();
    }

    private boolean buildGraph(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            addAlphabet(curr);

            addAlphabetPair(curr, next);
        }

        addAlphabet(words[words.length - 1]);

        return true;
    }

    private void addAlphabet(String word) {
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            alphabets.add(curr);
        }
    }

    private void addAlphabetPair(String curr, String next) {
        // take the shortest of curr and next
        int len = Math.min(curr.length(), next.length());

        // use an index to go through both words
        int index = 0;
        while (index < len) {
            char c1 = curr.charAt(index);
            char c2 = next.charAt(index);

            if (c1 == c2) {
                index++;
            } else {
                // find the first difference point
                if (!to[c1 - 'a'][c2 - 'a']) {
                    // if alphabet relationship is not setup, set it up now and add out-degree by 1
                    outDegree[c1 - 'a']++;
                    to[c1 - 'a'][c2 - 'a'] = true;
                }

                // break after first difference point
                break;
            }
        }
    }

    private String topoSort() {
        // always put no out-degree nodes into queue
        Queue<Character> zeroOut = new LinkedList<>();
        zeroOut.addAll(findZeroOut());

        StringBuilder sb = new StringBuilder();
        int len = alphabets.size();

        while (!zeroOut.isEmpty()) {
            // poll out curr char, add to result and remove from candidates
            char curr = zeroOut.poll();
            sb.append(curr);
            alphabets.remove(curr);

            // remove all path to curr
            for (int i = 0; i < 26; i++) {
                char before = (char) ('a' + i);

                // only can valid candidates
                if (!alphabets.contains(before))
                    continue;

                // skip current curr
                if (before == curr)
                    continue;

                // skip char with no relationship
                if (!to[before - 'a'][curr - 'a'])
                    continue;

                // remove path
                to[before - 'a'][curr - 'a'] = false;

                // decrease outdegree by 1
                outDegree[before - 'a']--;

                // if next candidate is of outdegree 0, add it into queue
                if (outDegree[before - 'a'] == 0) {
                    zeroOut.add(before);
                }
            }
        }

        // reverse result
        String rst = sb.reverse().toString();

        // if not all candidates are in result, there is a cycle, if not, return result
        return alphabets.size() == 0 ? rst : "";
    }

    // look for alphabet with outdegree = 0
    private List<Character> findZeroOut() {
        List<Character> rst = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            char curr = (char) ('a' + i);
            // only look for valid alphabets
            if (!alphabets.contains(curr))
                continue;

            // if out-degree = 0, add it into result
            if (outDegree[curr - 'a'] == 0) {
                rst.add(curr);
            }
        }
        return rst;
    }
}

