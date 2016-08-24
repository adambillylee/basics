import java.util.List;

/**
 * Created by adamli on 8/23/16.
 */
public class Contact {
    String name;
    List<String> emails;

    public Contact(String name, List<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", emails=" + emails.toString() +
                '}';
    }
}
