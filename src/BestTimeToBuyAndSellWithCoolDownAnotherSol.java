public class BestTimeToBuyAndSellWithCoolDownAnotherSol {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int buy = -prices[0];
        int coolDown = 0;
        int sell = 0;

        /**
         * we initialized first buy, so loop starts after first buy
         */
        for (int i = 1; i < prices.length; i++) {
            int tmp = buy;

            buy = Math.max(buy, coolDown - prices[i]);
            System.out.println("buy: " + buy);

            coolDown = Math.max(sell, coolDown);
            System.out.println("coolDown: " + coolDown);

            sell = tmp + prices[i];
            System.out.println("sell: " + sell);

            System.out.println();
        }

        return Math.max(coolDown, sell);
    }
}