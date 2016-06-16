import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adamli on 6/15/16.
 */
public class TwitterTest {
    Twitter obj = new Twitter();

    @Test
    public void testTweet1() throws Exception {
        obj.postTweet(1,2);
        obj.postTweet(2,3);
        List<Integer> param_2 = obj.getNewsFeed(1);

        obj.follow(1,2);
        param_2 = obj.getNewsFeed(1);

        obj.unfollow(1, 2);
        param_2 = obj.getNewsFeed(1);
        System.out.println();
    }

    @Test
    public void testTweet2() throws Exception {
        obj.postTweet(1,1);
        List<Integer> param_2 = obj.getNewsFeed(1);

        obj.follow(2,1);
        param_2 = obj.getNewsFeed(2);

        obj.unfollow(2, 1);
        param_2 = obj.getNewsFeed(1);
        System.out.println();
    }
}