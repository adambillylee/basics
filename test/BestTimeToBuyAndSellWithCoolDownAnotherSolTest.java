import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/26/16.
 */
public class BestTimeToBuyAndSellWithCoolDownAnotherSolTest {
    BestTimeToBuyAndSellWithCoolDownAnotherSol sol = new BestTimeToBuyAndSellWithCoolDownAnotherSol();

    @Test
    public void maxProfit() throws Exception {
        int price[] = {1,2,3,0,5};
        int rst = sol.maxProfit(price);
        System.out.println(rst);
    }

}