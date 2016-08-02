package factoryExample;

/**
 * Created by adamli on 3/28/16.
 */
public class MazeGame {
    public void makeGame() {
        Room one = makeRoom();
        Room two = makeRoom();
        one.connect(two);
    }

    public Room makeRoom() {
        return new OrdinaryRoom();
    }
}
