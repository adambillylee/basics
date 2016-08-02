import java.util.*;

/**
 * Created by adamli on 6/15/16.
 */
public class Twitter {
    private class Tweet {
        int tweetId;
        int order;

        public Tweet(int tweetId, int order) {
            this.tweetId = tweetId;
            this.order = order;
        }
    }

    int order = 0;
    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Set<Integer>> follows;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.tweets = new HashMap<>();
        this.follows = new HashMap<>();
    }

    /**
     * Compose a new tweet
     */
    public void postTweet(int userId, int tweetId) {
        if (tweets.containsKey(userId)) {
            tweets.get(userId).add(new Tweet(tweetId, order));
        } else {
            List<Tweet> tmp = new ArrayList<>();
            tmp.add(new Tweet(tweetId, order));
            tweets.put(userId, tmp);
        }
        order++;

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
            following = new HashSet<>();

        Comparator<Tweet> comparitor = new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.order - o1.order;
            }
        };
        PriorityQueue<Tweet> pq = new PriorityQueue<>(comparitor);

        for (int followee : following) {
            List<Tweet> tmp = tweets.get(followee);

            if (tmp == null)
                tmp = new ArrayList<>();

            pq.addAll(tmp);
        }

        while (!pq.isEmpty() && counter < 10) {
            rst.add(pq.poll().tweetId);
            counter++;
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