import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 4/23/16.
 */
public class PalindromePairs {
    private class Node {
        char c;
        Node[] next = new Node[27];
        Node prev;
        int val = -1;

        public Node() {
        }

        // insert char into trie
        void insert(char c) {
            int ind = c - 'a';

            if (this.next[ind] == null) {
                this.next[ind] = new Node();
            }

            Node next = this.next[ind];
            next.c = c;
            next.prev = this;
        }

        // search in next level and return node c
        // if not found return null
        Node get(char c) {
            int ind = c - 'a';

            return this.next[ind];
        }

        // look for palindrome word in reversed trie
        // if found return ind of that palindrome in words
        // else return -1
        int searchTrie(String word, int wordInd) {
            Node curr = this;

            for (char c : word.toCharArray()) {
                if (curr.get(c) != null) {
                    curr = curr.get(c);
                } else {
                    // if curr char cannot found in next lvl of trie
                    return -1;
                }
            }

            int returnVal = curr.val;

            // if current string is found but not at the end of trie
            // do a dfs on rest of the trie search for palindrome
            // if cannot be found, return -1
            if (!curr.isTail()) {
                returnVal = isSuffixPalindrome(curr, new StringBuilder());
            } else if (curr.val == wordInd) {
                return -1;
            }

            return returnVal;
        }

        boolean isTail() {
            for (Node tmp : this.next) {
                if (tmp != null)
                    return false;
            }

            return true;
        }

        int isSuffixPalindrome(Node curr, StringBuilder sb) {
            if (curr.isTail()) {
                if (isPalindrome(sb.toString())) {
                    System.out.println(sb.toString() + " is palindrome");
                    return curr.val;
                } else {
                    System.out.println(sb.toString() + " is not palindrome");
                    return -1;
                }
            }

            for (Node tmp : curr.next) {
                if (tmp != null) {
                    sb.append(tmp.c);
                    int path = isSuffixPalindrome(tmp, sb);

                    if (path != -1)
                        return path;
                    else
                        sb.deleteCharAt(sb.length() - 1);
                }
            }

            return -1;
        }
    }

    Node root = new Node();
    String[] words;

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new ArrayList<>();

        this.words = words;

        if (words == null || words.length == 0)
            return rst;

        buildTrie(words);
        searchTrie(rst, words);

        return rst;
    }

    void buildTrie(String words[]) {
        for (int i = 0; i < words.length; i++) {
            Node curr = root;

            String word = words[i];

            int wLen = word.length();

            // reverse the word and add into trie
            for (int j = wLen - 1; j >= 0; j--) {
                char c = word.charAt(j);

                curr.insert(c);
                curr = curr.get(c);
            }

            curr.val = i;
        }
    }

    void searchTrie(List<List<Integer>> rst, String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = new ArrayList<>();
            String word = words[i];

            int half = root.searchTrie(word, i);

            if (half != -1) {
                list.add(i);
                list.add(half);
                rst.add(new ArrayList(list));
            }

            if (word.isEmpty()) {

            }
        }
    }

    boolean isPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
