import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 5/19/16.
 */
public class MergeIntervalsTest {
    MergeIntervals sol = new MergeIntervals();

    @Test
    public void testLastElementCannotMerge() throws Exception {
        List<Interval> intervals =
                Arrays.asList(
                        new Interval(1, 3),
                        new Interval(2, 6),
                        new Interval(8, 10),
                        new Interval(15, 18)
                );

        List<Interval> rst = sol.merge(intervals);

        for (Interval interval : rst)
            interval.print();
    }

    @Test
    public void testSingleElement() throws Exception {
        List<Interval> intervals =
                Arrays.asList(
                        new Interval(1, 3)
                );

        List<Interval> rst = sol.merge(intervals);

        for (Interval interval : rst)
            interval.print();
    }

    @Test
    public void testLastElementMergeable() throws Exception {
        List<Interval> intervals =
                Arrays.asList(
                        new Interval(1, 3),
                        new Interval(2, 6),
                        new Interval(8, 10),
                        new Interval(9, 18)
                );

        List<Interval> rst = sol.merge(intervals);

        for (Interval interval : rst)
            interval.print();
    }

    @Test
    public void testEmpty() throws Exception {
        List<Interval> intervals = new ArrayList<>();

        List<Interval> rst = sol.merge(intervals);

        for (Interval interval : rst)
            interval.print();
    }

    @Test
    public void testNotSorted() throws Exception {
        List<Interval> intervals =
                Arrays.asList(
                        new Interval(1, 4),
                        new Interval(0, 0)
                );

        List<Interval> rst = sol.merge(intervals);

        for (Interval interval : rst)
            interval.print();
    }

    @Test
    public void testSameIntervel() throws Exception {
        List<Interval> intervals =
                Arrays.asList(
                        new Interval(1, 4),
                        new Interval(1, 4)
                );

        List<Interval> rst = sol.merge(intervals);

        for (Interval interval : rst)
            interval.print();
    }

}