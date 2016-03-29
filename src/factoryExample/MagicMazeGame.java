package factoryExample;

/**
 * Created by adamli on 3/28/16.
 */
public class MagicMazeGame extends MazeGame{
    @Override
    public Room makeRoom() {
        return new MagicRoom();
    }
}
