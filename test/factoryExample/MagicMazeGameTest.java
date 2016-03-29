package factoryExample;

import org.junit.Test;

/**
 * Created by adamli on 3/28/16.
 */
public class MagicMazeGameTest {

    @Test
    public void testMazeGame() {
        MazeGame one = new MazeGame();
        one.makeGame();

        MazeGame two = new MagicMazeGame();
        two.makeGame();
    }
}