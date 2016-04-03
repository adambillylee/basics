package builderExample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/2/16.
 */
public class BuilderTest {
    @Test
    public void builderTest() throws Exception {
        User test = new User.Builder("Adam", "lee")
                .address("my address")
                .age(17)
                .phone("911")
                .build();
    }
}