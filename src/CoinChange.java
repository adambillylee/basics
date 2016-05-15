/**
 * Created by adamli on 5/15/16.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // corner case
        if (amount == 0)
            return 0;

        int dp[] = new int[amount + 1];

        // initiate dp, set dp[0] = 0 to kick off
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // loop through all amounts
        for (int i = 0; i <= amount; i++) {
            // for each amount check each coin
            for (int coin : coins) {
                /**
                 * 1. if this amount < coin, cannot make up this amount for sure
                 * 2. it amount - coin can be made up, than this amount can be made up, with count = previous count + 1
                 */
                if (i >= coin && dp[i - coin] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // if amount take infinite coin to make up, return -1 for not found
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
