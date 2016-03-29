package factoryExample;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by adamli on 3/28/16.
 */
public class GUIFactoryTest {
    GUIFactory win;
    GUIFactory osx;

    @Before
    public void setup() {
        win = new WindowsGUIFactory();
        osx = new OSXGUIFactory();
    }
    @Test
    public void testCreateWinButton() {
        Button button = win.createButton();
        button.press();
    }

    @Test
    public void testCreateOSXButton() {
        Button button = osx.createButton();
        button.press();
    }
}