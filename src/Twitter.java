import java.util.*;

/**
 * Created by adamli on 6/15/16.
 */
public class Twitter {
    private class Tweet {
        int userId;
        int tweetId;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    List<Tweet> tweets;
    Map<Integer, Set<Integer>> follows = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.tweets = new ArrayList<>();
    }

    /**
     * Compose a new tweet
     */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId));
        follow(userId, userId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users
     * who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> rst = new ArrayList<>();
        int counter = 0;
        Set<Integer> following = follows.get(userId);

        if (following == null)
            following = new HashSet();

        for (int i = tweets.size() - 1; i >= 0; i--) {
            Tweet curr = tweets.get(i);

            if (!following.contains(curr.userId)) {
                continue;
            } else {
                counter++;
                rst.add(curr.tweetId);

                if (counter == 10)
                    break;
            }
        }

        return rst;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).add(followeeId);
        } else {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(followeeId);
            tmp.add(followerId);
            follows.put(followerId, tmp);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;

        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}