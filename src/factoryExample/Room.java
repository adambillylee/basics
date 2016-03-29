package factoryExample;

/**
 * Created by adamli on 3/28/16.
 */
public abstract class Room {
    String name;

    public void connect(Room input) {
        System.out.println(this.name + " is connected to " + input.name);
    }
}
