import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 5/21/16.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<>();

        if (intervals.size() == 0) {
            rst.add(newInterval);
            return rst;
        }

        // before newInterval, current.end < insert.start
        int curr = 0;
        while (curr < intervals.size() && intervals.get(curr).end < newInterval.start) {
            rst.add(intervals.get(curr));
            curr++;
        }

        // merge new interval, while current.start <= insert.end
        int start = newInterval.start;
        int end = newInterval.end;
        while (curr < intervals.size() && intervals.get(curr).start <= newInterval.end) {
            start = Math.min(start, intervals.get(curr).start);
            end = Math.max(end, intervals.get(curr).end);
            curr++;
        }

        Interval tmp = new Interval(start, end);
        rst.add(tmp);

        // add the rest of the elements
        while (curr < intervals.size()) {
            rst.add(intervals.get(curr));
            curr++;
        }

        return rst;
    }
}


