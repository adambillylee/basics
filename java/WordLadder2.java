import java.util.*;

/**
 * Created by adamli on 5/8/16.
 */
public class WordLadder2 {
    int maxDist = 1;
    boolean foundEnd = false;
    HashMap<String, HashSet<String>> reverseMap = new HashMap<>();
    HashMap<String, Integer> distance = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> rst = new ArrayList<>();

        /**
         * use to calculate all distance from begin to any word (wordlist + endword)
         */
        bfs(beginWord, endWord, new HashSet<>(), wordList);

        /**
         * dfs, starting from endWord and looking for beginWord
         * always select next node with distance = previous distance - 1
         */
        dfs(rst, endWord, beginWord, new ArrayList<>(), new HashSet<>(), maxDist);

        return rst;
    }

    private void bfs(String beginWord, String endWord, Set<String> visited, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String curr = queue.poll();

                if (visited.contains(curr))
                    continue;

                /**
                 * if found endword, mark flag be true
                 */
                if (curr.equals(endWord)) {
                    foundEnd = true;
                }

                distance.put(curr, maxDist);
                visited.add(curr);

                List<String> expended = expend(curr, endWord, visited, wordList);

                for (String next : expended) {
                    if (reverseMap.get(next) == null) {
                        reverseMap.put(next, new HashSet<>());
                    }

                    reverseMap.get(next).add(curr);
                }
                queue.addAll(expended);
            }

            /**
             * if found endWord, stop adding maxDistance
             */
            if (!foundEnd)
                maxDist++;
        }
    }

    private void dfs(List rst, String curr, String beginWord, List<String> list, Set<String> visited, int depth) {
        if (curr == beginWord) {
            /**
             * since path is reversed (from end to begin, we need to reverse before add to result)
             */
            list.add(curr);
            Collections.reverse(list);
            rst.add(new ArrayList<>(list));

            // BUG POINT: since its the end of DFS
            // reverse list back, and manually remove last element from list
            Collections.reverse(list);
            list.remove(list.size() - 1);

            return;
        }

        list.add(curr);
        visited.add(curr);

        Set<String> expended = reverseMap.get(curr);

        if (expended != null) {
            for (String back : expended) {
                /**
                 * always select nodes with distance = prev distance - 1
                 */
                if (distance.get(back) == depth - 1) {
                    dfs(rst, back, beginWord, list, visited, depth - 1);
                }
            }
        }

        list.remove(curr);
        visited.remove(curr);
    }

    private List<String> expend(String curr, String endWord, Set<String> visited, Set<String> wordList) {
        List<String> rst = new ArrayList<>();

        // for all chars in a word
        for (int i = 0; i < curr.length(); i++) {
            // try replace it with all 26 chars
            for (int j = 0; j < 26; j++) {
                char charArray[] = curr.toCharArray();
                char replaceChar = (char) ('a' + j);

                // skip if replace char is same as original
                if (replaceChar != charArray[i])
                    charArray[i] = replaceChar;
                else
                    continue;

                String replaced = String.valueOf(charArray);

                // if new word is valid, add to rst
                if (isValidExpendWord(endWord, visited, wordList, replaced)) {
                    rst.add(replaced);
                }
            }
        }

        return rst;
    }

    private boolean isValidExpendWord(String endWord, Set<String> visited, Set<String> wordList, String replaced) {
        // BUG POINT: remember to mark endWord as valid
        if (replaced.equals(endWord)) {
            return true;
        }

        if (visited.contains(replaced))
            return false;

        if (!wordList.contains(replaced))
            return false;

        return true;
    }
}
