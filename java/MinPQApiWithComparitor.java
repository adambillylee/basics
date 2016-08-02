import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by adamli on 1/11/16.
 */
public class MinPQApiWithComparitor {
    public static void sortWithAPI() {
        int a[] = {3,5,1,2,9};
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        // add numbers into pq
        for (int num:a)
            pq.add(num);

        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }

    public static void main(String[] args) {
        sortWithAPI();
    }
}
