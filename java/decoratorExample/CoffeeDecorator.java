package decoratorExample;

/**
 * Created by adamli on 4/2/16.
 */
public class CoffeeDecorator extends Coffee {
    protected final Coffee decoratedCoffee;
    protected String ingredientSeparator = ", ";

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }

    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
}
