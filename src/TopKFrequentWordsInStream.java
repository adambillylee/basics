import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by adamli on 3/17/16.
 */
public class TopKFrequentWordsInStream {
    /**
     * define an inner trie class
     */
    private class TrieNode {
        char val;
        TrieNode prev;
        HashMap<Character, TrieNode> next;
        int freq;
        boolean isTopK;
        boolean isRoot;

        TrieNode(char val) {
            this.val = val;
            this.prev = null;
            this.next = new HashMap<>();
            this.freq = 0;
            this.isTopK = false;
            this.isRoot = false;
        }

        boolean isTopK() {
            return this.isTopK;
        }

        boolean isRoot() {
            return this.isRoot;
        }
    }

    TrieNode root;
    int k;
    PriorityQueue<TrieNode> pq; // min heap


    public TopKFrequentWordsInStream(int k) {
        this.k = k;
        this.pq = new PriorityQueue<>(k, new Comparator<TrieNode>() {
            @Override
            public int compare(TrieNode o1, TrieNode o2) {
                return o1.val - o2.val;
            }
        });
        this.root = new TrieNode(' ');
        this.root.isRoot = true;
    }

    /**
     * find & print top K frequent words from a stream (String[])
     *
     * @param words
     */
    public void printTopK(String[] words) {

        for (String word : words) {
            addWord(word);
        }

        printTopK();
    }

    /**
     * add a word into trie and update topK pq
     *
     * @param word new word to add into trie and update topK for
     */
    private void addWord(String word) {
        TrieNode curr = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            // try to create new node
            char c = word.charAt(i);

            TrieNode node = new TrieNode(c);
            node.prev = curr;

            // put new node into curr.next
            if (!curr.next.containsKey(c)) {
                curr.next.put(c, node);
            } else {
                /**
                 * there is a possibility that node is created but not set to curr.next (when it exists)
                 * make sure node is referring to the correct trie node (the existing one)
                 */
                node = curr.next.get(c);
            }

            // if this is the last char in word
            if (i == len - 1) {
                node.freq++;
                updatePq(node);
            }

            curr = node;
        }
    }

    private void updatePq(TrieNode node) {
        /**
         * case 1:
         * if node is already topK, its not gonna drop out of topK
         * remove and offer it back to update its freq
         */
        if (node.isTopK()) {
            pq.remove(node);
            pq.offer(node);
        } else {
            /**
             * case 2:
             * if node not in topK pq yet and pq is not full, add it anyway
             */
            if (pq.size() < k) {
                pq.offer(node);
                node.isTopK = true;
            } else {
                /**
                 * case 3:
                 * if node not in topK pq but bigger than minNode in TopK (at root)
                 * pop the root and add in pq
                 * update isTopK status of both minNode and node
                 */
                if (node.freq > pq.peek().freq) {
                    // update min node
                    TrieNode minNode = pq.poll();
                    minNode.isTopK = false;

                    // update node
                    pq.offer(node);
                    node.isTopK = true;
                }
            }
        }
    }

    private void printTopK() {
        while (!pq.isEmpty()) {
            TrieNode curr = pq.poll();
            int freq = curr.freq;

            StringBuilder sb = new StringBuilder();
            while (!curr.isRoot) {
                sb.append(curr.val);
                curr = curr.prev;
            }

            System.out.println(sb.reverse().toString() + " : " + freq);
        }
    }
}