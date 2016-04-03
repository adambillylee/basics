package decoratorExample;

import org.junit.Test;

/**
 * Created by adamli on 4/2/16.
 */
public class CoffeeTest {
    @Test
    public void testDecorateCoffee() throws Exception {
        Coffee expresso = new Expresso();
        printInfo(expresso);

        Coffee milkCoffee = new Milk(expresso);
        printInfo(milkCoffee);

        Coffee whipCoffee = new Whip(expresso);
        printInfo(whipCoffee);

        Coffee sprinkledMilkCoffee = new Sprinkles(milkCoffee);
        printInfo(sprinkledMilkCoffee);
    }

    private void printInfo(Coffee coffee) {
        System.out.println("Cost: " + coffee.getCost() + ", Ingredients: " + coffee.getIngredients());
    }
}
