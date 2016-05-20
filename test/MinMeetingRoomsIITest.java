import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 5/20/16.
 */
public class MinMeetingRoomsIITest {
    MinMeetingRooms sol = new MinMeetingRooms();

    @Test
    public void minMeetingRooms1() throws Exception {
        Interval intervals[] = {
                new Interval(1, 17),
                new Interval(7, 10),
                new Interval(12, 14)
        };

        assertEquals(2, sol.minMeetingRooms(intervals));
    }

    @Test
    public void minMeetingRooms2() throws Exception {
        Interval intervals[] = {
                new Interval(9, 10),
                new Interval(4, 9),
                new Interval(4, 17)
        };

        assertEquals(2, sol.minMeetingRooms(intervals));
    }

}