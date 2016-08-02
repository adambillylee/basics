import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by adamli on 5/31/16.
 */
public class FindMediumFromDataStream {
    PriorityQueue<Double> leftMax = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Double> rightMin = new PriorityQueue<>();
    int total = 0;

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (leftMax.isEmpty() || num < leftMax.peek()) {
            leftMax.offer((double) num);

            if (leftMax.size() - rightMin.size() > 1) {
                rightMin.offer(leftMax.poll());
            }
        } else {
            rightMin.offer((double) num);

            if (rightMin.size() > leftMax.size()) {
                leftMax.offer(rightMin.poll());
            }
        }

        total++;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (total == 0)
            return 0;

        if (total % 2 == 0) {
            return (leftMax.peek() + rightMin.peek()) / 2;
        } else {
            return leftMax.peek();
        }
    }
}
