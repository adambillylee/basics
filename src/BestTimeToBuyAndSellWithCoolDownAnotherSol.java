public class BestTimeToBuyAndSellWithCoolDownAnotherSol {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int buy = -prices[0];
        int coolDown = 0;
        int sell = prices[1] - prices[0];

        for (int i = 0; i < prices.length; i++) {
            int tmp = buy;
            buy = Math.max(buy, coolDown - prices[i]);

            /**
             * the first coolDown is only valid at i = 2 (day 3)
             */
            if (i >= 2)
                coolDown = Math.max(sell, coolDown);

            /**
             * the first sell can only happen at i = 1 (day 2)
             */
            if (i >= 1)
                sell = tmp + prices[i];
        }

        return Math.max(coolDown, sell);
    }
}