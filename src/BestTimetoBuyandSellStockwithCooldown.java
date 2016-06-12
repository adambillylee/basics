/**
 * Created by adamli on 6/11/16.
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfitLinearSpace(int[] prices) {
        if (prices.length < 2 || prices == null)
            return 0;

        int rest[] = new int[prices.length];
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        // for first state (prices[0])
        rest[0] = 0;
        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            /**
             * if we rest now
             * last action could be last rest or last sell
             */
            rest[i] = Math.max(rest[i-1], sell[i-1]);

            /**
             * if we buy now
             * last action could be rest (money of last buy)
             * or rest (money = rest[i-1] - price[i])
             */
            buy[i] = Math.max(rest[i-1] - prices[i], buy[i-1]);

            /**
             * if we sell now
             * last action can only be last rest (money of last rest)
             */
            sell[i] = buy[i-1] + prices[i];
        }

        return Math.max(sell[prices.length-1], rest[prices.length-1]);
    }

    public int maxProfitConstantSpace(int[] prices) {
        if (prices.length < 2 || prices == null)
            return 0;

        // for first state (prices[0])
        int rest = 0;
        int buy = -prices[0];
        int sell = 0;

        /**
         * reduce previous solution to space O(1)
         */
        for (int i = 1; i < prices.length; i++) {
            int last_rest = rest;
            rest = Math.max(last_rest, sell);

            int last_buy = buy;
            buy = Math.max(last_rest - prices[i], buy);

            sell = last_buy + prices[i];
        }

        return Math.max(sell, rest);
    }
}
