import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 5/21/16.
 */
public class InsertIntervalTest {
    InsertInterval sol = new InsertInterval();

    @Test
    public void insert1() throws Exception {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 2),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(8, 10),
                new Interval(12, 16)
        );

        List<Interval> rst = sol.insert(intervals, new Interval(4, 9));

        for (Interval ele : rst)
            ele.print();
    }

    @Test
    public void insert2() throws Exception {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(6, 9)
        );

        List<Interval> rst = sol.insert(intervals, new Interval(2, 5));

        for (Interval ele : rst)
            ele.print();
    }

    @Test
    public void insert3() throws Exception {
        List<Interval> intervals = Arrays.asList(
                new Interval(1,5)
        );

        List<Interval> rst = sol.insert(intervals, new Interval(2, 3));

        for (Interval ele : rst)
            ele.print();
    }

    @Test
    public void insert4() throws Exception {
        List<Interval> intervals = Arrays.asList(
                new Interval(1,2)
        );

        List<Interval> rst = sol.insert(intervals, new Interval(2, 3));

        for (Interval ele : rst)
            ele.print();
    }

}