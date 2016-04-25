import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 4/24/16.
 */
public class CourseScheduleTest {
    CourseSchedule sol = new CourseSchedule();

    @Test
    public void canFinish() throws Exception {
        int numOfCourses = 3;
        int prerequisites[][] = {{0,2},{1,2},{2,0}};

        assertFalse(sol.canFinish(numOfCourses, prerequisites));

    }

}