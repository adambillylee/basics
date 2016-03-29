package singletonExample;

/**
 * Created by adamli on 3/28/16.
 */
public class Singleton {
    /**
     * has to be final
     * constructor must be private
     */
    private static Singleton INSTANCE = null;

    // Stop public new Singleton()
    private Singleton() {
        //.... set wherever is needed
    }

    public static Singleton getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Singleton();

        return INSTANCE;
    }
}
