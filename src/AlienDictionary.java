import java.util.*;

public class AlienDictionary {
    private boolean to[][] = new boolean[26][26];
    private int outDegree[] = new int[26];
    private Set<Character> alphabets = new HashSet<>();

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

            addNodeInword(curr);

            if (!addNodeAcrossWords(curr, next))
                return false;
        }

        addNodeInword(words[words.length - 1]);

        return true;
    }

    private void addNodeInword(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            char curr = word.charAt(i);
            char next = word.charAt(i + 1);

            alphabets.add(curr);
            alphabets.add(next);
        }
    }

    private boolean addNodeAcrossWords(String curr, String next) {
        int len = Math.min(curr.length(), next.length());

        int index = 0;
        while (index < len) {
            char c1 = curr.charAt(index);
            char c2 = next.charAt(index);
            alphabets.add(c1);
            alphabets.add(c2);

            if (c1 == c2) {
                index++;
            } else {
                to[c1 - 'a'][c2 - 'a'] = true;
                System.out.println("from " + c1 + " to " + c2);

                break;
            }
        }

        return true;
    }

    private String topoSort() {
        Queue<Character> zeroOut = new LinkedList<>();
        zeroOut.addAll(findZeroOut());

        StringBuilder sb = new StringBuilder();
        int len = alphabets.size();

        while (!zeroOut.isEmpty()) {
            char curr = zeroOut.poll();
            sb.append(curr);
            alphabets.remove(curr);

            // remove all path to curr
            for (int i = 0; i < 26; i++) {
                char before = (char) ('a' + i);

                if (!alphabets.contains(before))
                    continue;

                if (before == curr)
                    continue;

                if (!to[before - 'a'][curr - 'a'])
                    continue;

                // remove path
                to[before - 'a'][curr - 'a'] = false;
//                System.out.println("remove " + before + " to " + curr);
                outDegree[before - 'a']--;
//                System.out.println("degree of " + before + " to " + outDegree[before - 'a']);

                if (outDegree[before - 'a'] == 0) {
                    zeroOut.add(before);
//                    System.out.println("add : " + before);
                }
            }
        }

        String rst = sb.reverse().toString();
        return rst.length() == len ? rst : "";
    }

    private List<Character> findZeroOut() {
        List<Character> rst = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            char curr = (char) ('a' + i);
            if (!alphabets.contains(curr))
                continue;

            if (outDegree[curr - 'a'] == 0) {
                rst.add(curr);
//                System.out.println("add : " + curr);
            }
        }
        return rst;
    }
}

