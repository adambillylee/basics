import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by adamli on 7/17/16.
 */
public class MaxPointsOnALineTest {
    MaxPointsOnALine sol = new MaxPointsOnALine();

    @Test
    public void testMaxPoints1() throws Exception {
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(-1, -1);
        points[2] = new Point(2, 2);

        Assert.assertEquals(sol.maxPoints(points), 3);
    }

    @Test
    public void testMaxPoints2() throws Exception {
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(0, 0);

        Assert.assertEquals(sol.maxPoints(points), 3);
    }

    @Test
    public void testMaxPoints3() throws Exception {
        Point[] points = new Point[2];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);

        Assert.assertEquals(sol.maxPoints(points), 2);
    }

    @Test
    public void testMaxPoints4() throws Exception {
        Point[] points = new Point[3];
        points[0] = new Point(2, 3);
        points[1] = new Point(3, 3);
        points[2] = new Point(-5, 3);

        Assert.assertEquals(sol.maxPoints(points), 3);
    }

    @Test
    public void testMaxPoints5() throws Exception {
        Point[] points = new Point[15];
        points[0] = new Point(0, -12);
        points[1] = new Point(5, 2);
        points[2] = new Point(2, 5);
        points[3] = new Point(0, -5);
        points[4] = new Point(1, 5);
        points[5] = new Point(2, -2);
        points[6] = new Point(5, -4);
        points[7] = new Point(3, 4);
        points[8] = new Point(-2, 4);
        points[9] = new Point(-1, 4);
        points[10] = new Point(0, -5);
        points[11] = new Point(0, -8);
        points[12] = new Point(-2, -1);
        points[13] = new Point(0, -11);
        points[14] = new Point(0, -9);

        Assert.assertEquals(sol.maxPoints(points), 6);
    }
}