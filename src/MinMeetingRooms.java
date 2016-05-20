import java.util.Arrays;

/**
 * Created by adamli on 5/20/16.
 */
public class MinMeetingRooms {
    public int minMeetingRooms(Interval[] intervals) {
        int starts[] = new int[intervals.length];
        int ends[] = new int[intervals.length];

        // add all starts and ends into array
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        // sort start time and end time
        Arrays.sort(starts);
        Arrays.sort(ends);

        // initialization
        int room = 0;
        int currEnd = 0;
        /**
         * check all starts and ends
         */
        for (int start : starts) {
            /**
             * if current end time > new start time, we have a conflict and needs a new room
             */
            if (start < ends[currEnd]) {
                room++;
            } else {
                /**
                 * if curr end time < new start time, there is no conflict so no need for a new room
                 */
                currEnd++;
            }
        }

        return room;
    }
}
