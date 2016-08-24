import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 8/23/16.
 */
public class GroupContactsTest {
    GroupContacts sol = new GroupContacts();
    List<Contact> input = new ArrayList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        input.add(new Contact("John", Arrays.asList("john@gmail.com")));
        input.add(new Contact("Mary", Arrays.asList("mary@gmail.com")));
        input.add(new Contact("John", Arrays.asList("john@yahoo.com")));
        input.add(new Contact("John", Arrays.asList("john@gmail.com", "john@yahoo.com", "john@hotmail.com")));
        input.add(new Contact("Bob", Arrays.asList("bob@gmail.com")));
    }

    @Test
    public void testGroupContacts() throws Exception {
        List<List<Contact>> rst = sol.groupContacts(input);
        System.out.println(rst);
    }

}