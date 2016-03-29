package factoryExample;

/**
 * Created by adamli on 3/28/16.
 */
public abstract class Button {
    String name;

    public void press() {
        System.out.println(this.name);
    }
}
