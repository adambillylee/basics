import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by adamli on 3/8/16.
 */
public class HighestWordCompositionTest {

    @Test
    public void testFindTopKComposition() throws Exception {
        ArrayList<Composition> input = new ArrayList<>();
        Composition c1 = new Composition("w1",2);
        Composition c2 = new Composition("w2",4);
        Composition c3 = new Composition("w3",1);
        Composition c4 = new Composition("w4",6);

        input.add(c1);
        input.add(c2);
        input.add(c3);
        input.add(c4);

        ArrayList<Composition> rst = HighestWordComposition.findTopKComposition(input);
        System.out.println();
    }
}