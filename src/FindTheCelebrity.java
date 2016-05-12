/**
 * Created by adamli on 5/9/16.
 */
public class FindTheCelebrity {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int celebrity = 0;

            for (int i=1; i<n; i++) {
                if (knows(celebrity, i)) {
                    celebrity = i;
                }
            }

            int i = 0;
            while (i<n) {
                if (i == celebrity || (!knows(celebrity, i) && knows(i, celebrity))) {
                    System.out.println(i);
                }
                else {
                    break;
                }
                i++;
            }

            if (i == n)
                return celebrity;
            else
                return -1;
        }
    }

    private class Relation {
        boolean knows(int i, int j) {
            return true;
        }
    }
}
