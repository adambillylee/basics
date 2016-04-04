public class EditDistance {
    public static int minDistance(String word1, String word2) {
        /**
         * edit distance from 0~ith char in word1 to 0~jth char in word2 (all inclusive)
         * i / j = 0 means take no char from word1 / word2
         * matrix index = string index + 1
         */
        int M[][] = new int[word1.length()+1][word2.length()+1];

        for (int i=0; i<=word1.length(); i++) {
            for (int j=0; j<=word2.length(); j++) {
                // empty string to word with j chars takes j edits
                if (i == 0) {
                    M[i][j] = j;
                    continue;
                }

                // i chars string to empty takes i edits
                if (j == 0) {
                    M[i][j] = i;
                    continue;
                }

                /**
                 * BUG POINT: if M[i][j] definition is not String index
                 * all charAt() or substring() index must be M index-1
                 */
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    M[i][j] = M[i - 1][j - 1];
                    continue;
                }

                M[i][j] = Integer.MAX_VALUE;

                /**
                 * edit distance of previous char from word1 to prev char in word2
                 * and 1 edit for replace current char
                 */
                int rep = M[i-1][j-1]+1;
                M[i][j] = Math.min(rep, M[i][j]);

                /**
                 * edit distance of from prev char in word1 to curr char in word2
                 * and 1 edit for delete curr char from word1
                 */
                int del = M[i-1][j]+1;
                M[i][j] = Math.min(del, M[i][j]);

                /**
                 * edit distance of from curr char in word1 to prev char in word2
                 * and 1 edit for inserting a new char to word1
                 */
                int ins = M[i][j-1]+1;
                M[i][j] = Math.min(ins, M[i][j]);
            }
        }

        return M[word1.length()][word2.length()];
    }
}