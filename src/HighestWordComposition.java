import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by adamli on 3/8/16.
 */
public class HighestWordComposition {
    public static ArrayList<Composition> findTopKComposition(ArrayList<Composition> input) {
        if (input == null || input.size() == 0) {
            return null;
        }

        Comparator<Composition> comparator = new Comparator<Composition>() {
            @Override
            public int compare(Composition o1, Composition o2) {
                return o2.composition - o1.composition;
            }
        };

        PriorityQueue<Composition> pq = new PriorityQueue<>(2, comparator);

        for (Composition ele : input) {
            pq.offer(ele);
        }

        ArrayList<Composition> rst = new ArrayList<>();
        rst.add(pq.poll());
        rst.add(pq.poll());

        return rst;
    }
}

class Composition {
    public String word;
    public int composition;

    public Composition(String word, int composition) {
        this.word = word;
        this.composition = composition;
    }
}
