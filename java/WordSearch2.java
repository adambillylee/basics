import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;    // will only be word if this TrieNode is leaf

        // check if this node is leaf
        boolean isWord() {
            return this.word != null;
        }

        // add char into current trie
        void addNext(char c) {
            this.next[c - 'a'] = new TrieNode();
        }

        // check if char c is in next level of current node
        boolean hasNext(char c) {
            return next[c - 'a'] != null;
        }

        // get next level TrieNode of char c
        TrieNode getNext(char c) {
            return next[c - 'a'];
        }
    }

    /**
     * build trie from string array
     *
     * @param words input words array
     * @return completed root node
     */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                // if node for c is not in next level, create one
                if (!curr.hasNext(c)) {
                    curr.addNext(c);
                }

                // move cursor to next level
                curr = curr.getNext(c);
            }
            // at the end of word, fill in word in current node
            curr.word = word;
        }

        return root;
    }

    public void helper(char[][] board, int row, int col, TrieNode curr, List<String> rst) {
        //check if current cell is valid
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;

        char c = board[row][col];

        // check if current cell is visited
        if (c == '$')
            return;

        // check if current char is in trie
        if (!curr.hasNext(c))
            return;

        /**
         * bug point: need to move curr cursor to corresponding trie node
         * curr node will "not" be the leaf if not moved
         */
        curr = curr.getNext(c);

        // if it is word
        if (curr.isWord()) {
            rst.add(curr.word);
            System.out.println(curr.word);

            /**
             * remove the word from trie, for de-duplication
             */
            curr.word = null;

            /**
             * bug point: DO NOT RETURN HERE
             * ext: "benda", "benda"
             * returning here will stop DFS from searching for longer and deeper solutions
             */
        }

        // classic DFS template
        board[row][col] = '$';
        helper(board, row + 1, col, curr, rst);
        helper(board, row, col + 1, curr, rst);
        helper(board, row - 1, col, curr, rst);
        helper(board, row, col - 1, curr, rst);
        board[row][col] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> rst = new ArrayList<>();

        /**
         * bug point 2:
         * need to check every staring point
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, root, rst);
            }
        }

        return rst;
    }
}