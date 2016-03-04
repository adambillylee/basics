import java.util.ArrayList;

/**
 * Created by adamli on 3/2/16.
 */
public class FindCombination {
    static int coins[] = null;


    public static ArrayList<int[]> main(int total, int[] coins) {
        ArrayList<int[]> rst = new ArrayList<int[]>();
        FindCombination.coins = coins;

        FindCombination.FindCombination(total, 0, new int[4], rst);

        return rst;
    }

    public static void FindCombination(int money_left, int level, int[] sol, ArrayList<int []> rst) {
        if (level == coins.length) {

            if (money_left == 0) {
                for (int i: sol) {
                    System.out.print(i + " " );
                }

                System.out.println();
                rst.add(sol);
            }

            return;
        }

        for (int i = 0; i<=money_left / coins[level]; ++i) {
            sol[level] = i;
            FindCombination(money_left - i* coins[level], level+1, sol, rst);
        }
    }
}
