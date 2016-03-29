package factoryExample;

/**
 * Created by adamli on 3/28/16.
 */
public class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
