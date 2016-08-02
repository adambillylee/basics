import java.util.*;

/**
 * Created by adamli on 5/21/16.
 */
public class Skyline {
    private class KeyPoint {
        int point;
        Set<Integer> starts;
        Set<Integer> ends;

        KeyPoint(int point) {
            this.point = point;
            this.starts = new HashSet<>();
            this.ends = new HashSet<>();
        }
    }

    Map<Integer, KeyPoint> map = new HashMap<>();
    List<KeyPoint> points = new ArrayList<>();

    public List<int[]> getSkyline(int[][] buildings) {
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            int start = building[0];
            int end = building[1];

            if (!map.containsKey(start)) {
                KeyPoint tmpStart = new KeyPoint(start);
                map.put(start, tmpStart);
                points.add(tmpStart);
            }
            map.get(start).starts.add(i);
            System.out.println("building" + i + " starts at " + start);

            if (!map.containsKey(end)) {
                KeyPoint tmpEnd = new KeyPoint(end);
                map.put(end, tmpEnd);
                points.add(tmpEnd);
            }
            map.get(end).ends.add(i);
            System.out.println("building" + i + " starts at " + start);
        }

        List<int[]> rst = new ArrayList<>();

        Comparator<KeyPoint> comparator = new Comparator<KeyPoint>() {
            @Override
            public int compare(KeyPoint o1, KeyPoint o2) {
                return o1.point - o2.point;
            }
        };
        Collections.sort(points, comparator);

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(0);
        for (KeyPoint point : points) {
            for (int start : point.starts) {
                heap.add(buildings[start][2]);
            }

            for (int end : point.ends) {
                heap.remove(buildings[end][2]);
            }

            int height = heap.peek();
            if (rst.size() == 0 || rst.get(rst.size() - 1)[1] != height) {
                rst.add(new int[]{point.point, height});
                System.out.println("add result: " + point.point + "," + height);
            }
        }

        return rst;
    }
}
