package org.yuhang.algorithm.leetcode.design;

import java.util.*;

/**
 * 设计推特 LC355
 */
public class Twitter {

    volatile int tweetSeq;

    Map<Integer,Queue<Tweet>> tweetMap;//用户id与博文列表关系

    Map<Integer,Set<Integer>> followMap;//用户id与关注的用户id列表关系,关注的用户id不能重复


    class Tweet{
        private int userId;
        private int tweetId;
        private int seqnum;

        public Tweet(int userId, int tweetId, int seqnum) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.seqnum = seqnum;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId,tweetId,tweetSeq++);//生成微博
        Queue<Tweet> userTweets = tweetMap.get(userId);//找到用户微博列表
        if(userTweets == null){
            userTweets = new PriorityQueue<>((o1,o2)->o2.seqnum-o1.seqnum);
        }
        userTweets.add(tweet);
        tweetMap.put(userId,userTweets);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = followMap.get(userId);//找出关注列表
        Queue<Tweet> userTweets = tweetMap.get(userId);//找出作者发博数
        Queue<Tweet> newsFeed = new PriorityQueue<>((o1,o2)->o2.seqnum-o1.seqnum);
        if(follows !=null){
           for (int follow:follows){
               Queue<Tweet> followTweets = tweetMap.get(follow);
               if(followTweets!=null) {
                   newsFeed.addAll(followTweets);
               }
           }
        }
        if(userTweets!=null) {
            newsFeed.addAll(userTweets);
        }
        List<Integer> res = new ArrayList<>();
        int cnt =1;
        while (!newsFeed.isEmpty() && cnt <=10){
            res.add(newsFeed.poll().tweetId);
            cnt++;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId) return; //自己不能关注自己
        Set<Integer> follows = followMap.get(followerId);//找出关注列表
        if(follows==null) {
            follows = new HashSet<>();
        }
        follows.add(followeeId);
        followMap.put(followerId,follows);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId == followerId) return; //自己不能取消关注自己
        Set<Integer> follows = followMap.get(followerId);//找出关注列表
        if(follows!=null) {
            follows.remove(followeeId);
        }
        followMap.put(followerId,follows);
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);


    }


}
