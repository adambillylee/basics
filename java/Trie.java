/**
 * Created by adamli on 5/14/16.
 */
class TrieNode {
    String word;
    TrieNode[] next;

    // Initialize your data structure here.
    public TrieNode() {
        word = null;
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (curr.next[index] == null)
                curr.next[index] = new TrieNode();

            curr = curr.next[index];
        }
        curr.word = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (curr.next[index] == null)
                return false;

            curr = curr.next[index];
        }

        return curr.word != null && curr.word.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';

            if (curr.next[index] == null)
                return false;

            curr = curr.next[index];
        }

        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
