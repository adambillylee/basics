/**
 * Created by adamli on 5/14/16.
 */

public class AddandSearchWord {
    private class TrieNode {
        String word;
        TrieNode[] next;

        // Initialize your data structure here.
        public TrieNode() {
            word = null;
            next = new TrieNode[27];
        }
    }

    private TrieNode root;

    public AddandSearchWord() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            int index;
            if (c == '.') {
                index = 26;
            }else{
                index = c - 'a';
            }

            if (curr.next[index] == null)
                curr.next[index] = new TrieNode();

            curr = curr.next[index];
        }
        curr.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return DFS(word, root);
    }

    private boolean DFS(String word, TrieNode root) {
        if (word.isEmpty())
            return root.word != null;

        TrieNode curr = root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if (c != '.') {
                int index = c - 'a';

                if (curr.next[index] == null)
                    return false;

                curr = curr.next[index];
            }else{
                for (TrieNode tmp : curr.next) {
                    if (tmp != null && DFS(word.substring(i+1), tmp))
                        return true;
                }

                return false;
            }
        }

        return curr.word != null;
    }
}
