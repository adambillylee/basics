package decoratorExample;

/**
 * Created by adamli on 4/2/16.
 */
public class Sprinkles extends CoffeeDecorator {
    public Sprinkles(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getIngredients() {
        return super.getIngredients() + ingredientSeparator + "sprinkles";
    }
}
