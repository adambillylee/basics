import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamli on 7/17/16.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;

        if (points.length == 1)
            return 1;

        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopes = new HashMap<>();
            int sameP = 0;
            int sameL = 0;
            for (int j = i + 1; j < points.length; j++) {
                /**
                 * bug point 1:
                 * input may contains same point, have to count them separately
                 */
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    sameP++;
                    continue;
                }

                double slope = getSlope(points[i], points[j]);

                if (slopes.containsKey(slope)) {
                    int count = slopes.get(slope);
                    count++;
                    slopes.put(slope, count);
                    sameL = Math.max(sameL, count);
                } else {
                    slopes.put(slope, 1);
                    sameL = Math.max(sameL, 1);
                }
            }

            max = Math.max(max, sameL + sameP + 1);
        }

        return max;
    }

    double getSlope(Point a, Point b) {
        /**
         * bug point 2:
         * there are -0.0 and 0.0 in double
         */
        if (a.y == b.y)
            return 0.0;

        if (a.x == b.x)
            return Double.POSITIVE_INFINITY;

        return ((a.y - b.y) + 0.0) / (a.x - b.x);
    }
}