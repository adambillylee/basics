/**
 * Created by adamli on 5/13/16.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDis = Integer.MAX_VALUE;

        // from left to right, search for closest distance
        int last2 = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // if last position of string2 from left is found
            if (word.equals(word1) && last2 != -1) {
                int currDis = Math.abs(i - last2);

                // update min distance if string1 and string2 are two individual words in list
                if (currDis > 0)
                    minDis = Math.min(currDis, minDis);
            }

            // update last string2 position
            if (word.equals(word2)) {
                last2 = i;
            }
        }

        // from right to left, search for closest distance
        last2 = words.length;
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];

            // if last position of string2 from left is found
            if (word.equals(word1) && last2 != words.length) {
                int currDis = Math.abs(last2 - i);

                // update min distance if string1 and string2 are two individual words in list
                if (currDis > 0)
                    minDis = Math.min(currDis, minDis);
            }

            // update last string2 position
            if (word.equals(word2)) {
                last2 = i;
            }

        }

        return minDis;
    }
}
