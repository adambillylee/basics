package decoratorExample;

/**
 * Created by adamli on 4/2/16.
 */
public class Whip extends CoffeeDecorator {
    public Whip(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.7;
    }

    public String getIngredients() {
        return super.getIngredients() + ingredientSeparator + "whip";
    }
}
