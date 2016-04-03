package decoratorExample;

/**
 * Created by adamli on 4/2/16.
 */
public class Expresso extends Coffee {
    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "expresso";
    }
}

