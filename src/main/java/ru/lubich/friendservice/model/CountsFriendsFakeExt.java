package ru.lubich.friendservice.model;

import java.math.BigInteger;

/**
 * Created by Евгений on 22.06.2017.
 */
public class CountsFriendsFakeExt {
    private BigInteger FriendsCount;
    private BigInteger FriendsOutRequest;
    private BigInteger friendsInRequest;
    private Iterable<Integer> friend_id;
    private Iterable<Integer> friend_out_id;
    private Iterable<Integer> friend_in_id;


    public CountsFriendsFakeExt(BigInteger friendsCount, BigInteger friendsOutRequest, BigInteger friendsInRequest, Iterable<Integer> friend_id, Iterable<Integer> friend_out_id, Iterable<Integer> friend_in_id) {
        FriendsCount = friendsCount;
        FriendsOutRequest = friendsOutRequest;
        this.friendsInRequest = friendsInRequest;
        this.friend_id = friend_id;
        this.friend_out_id = friend_out_id;
        this.friend_in_id = friend_in_id;
    }

    public BigInteger getFriendsCount() {
        return FriendsCount;
    }

    public void setFriendsCount(BigInteger friendsCount) {
        FriendsCount = friendsCount;
    }

    public BigInteger getFriendsOutRequest() {
        return FriendsOutRequest;
    }

    public void setFriendsOutRequest(BigInteger friendsOutRequest) {
        FriendsOutRequest = friendsOutRequest;
    }

    public BigInteger getFriendsInRequest() {
        return friendsInRequest;
    }

    public void setFriendsInRequest(BigInteger friendsInRequest) {
        this.friendsInRequest = friendsInRequest;
    }

    public Iterable<Integer> getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Iterable<Integer> friend_id) {
        this.friend_id = friend_id;
    }

    public Iterable<Integer> getFriend_out_id() {
        return friend_out_id;
    }

    public void setFriend_out_id(Iterable<Integer> friend_out_id) {
        this.friend_out_id = friend_out_id;
    }

    public Iterable<Integer> getFriend_in_id() {
        return friend_in_id;
    }

    public void setFriend_in_id(Iterable<Integer> friend_in_id) {
        this.friend_in_id = friend_in_id;
    }
}
