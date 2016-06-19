import java.util.Arrays;

/**
 * Created by adamli on 6/19/16.
 */
public class FriendsCircle {
    public int findCircle(String[] friends) {
        if (friends == null || friends.length == 0)
            return 0;

        int n = friends.length;
        char friendship[][] = new char[n][n];
        int boss[] = new int[n];
        Arrays.fill(boss, -1);

        // build friendship
        for (int i = 0; i < n; i++) {
            friendship[i] = friends[i].toCharArray();
        }

        union(n, friendship, boss);

        int circles = 0;
        for (int i : boss) {
            if (i == -1)
                circles++;
        }


        return circles;
    }

    private void union(int n, char[][] friendship, int[] boss) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (friendship[i][j] == 'Y') {
                    int bossI = find(boss, i);
                    int bossJ = find(boss, j);

                    if (bossI == bossJ)
                        continue;

                    boss[bossI] = bossJ;
                }
            }
        }
    }

    private int find(int[] boss, int i) {
        if (boss[i] == -1)
            return i;

        return find(boss, boss[i]);
    }
}
