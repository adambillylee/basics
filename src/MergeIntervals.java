import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by adamli on 5/19/16.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();

        // sanity check
        if (intervals.size() <= 1)
            return intervals;

        // sort all intervals by start time first
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);

        // set first start and end from first interval
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            /**
             * if new interval overlaps on current interval,
             * BUGPOINT:
             * update end interval with math of current end and new end (since current end could still be bigger)
             */
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                /**
                 * if there is no overlap ,add new interval into rst
                 */
                rst.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        /**
         * BUGPOINT:
         * the very last start and end interval will never get add into result
         * add this latest interval into rst
         */
        rst.add(new Interval(start, end));
        return rst;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    String print() {
        String prt = start + ",\t" + end;
        System.out.println(prt);
        return prt;
    }
}
