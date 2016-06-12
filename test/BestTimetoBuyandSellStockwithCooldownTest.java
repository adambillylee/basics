import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/12/16.
 */
public class BestTimetoBuyandSellStockwithCooldownTest {
    BestTimetoBuyandSellStockwithCooldown sol = new BestTimetoBuyandSellStockwithCooldown();

    @Test
    public void maxProfit() throws Exception {
        int prices[] = {2,1};
        Assert.assertEquals(0, sol.maxProfitConstantSpace(prices));
    }

}