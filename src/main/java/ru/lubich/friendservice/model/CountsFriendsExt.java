package ru.lubich.friendservice.model;

import java.math.BigInteger;

/**
 * Created by Евгений on 24.06.2017.
 */
public class CountsFriendsExt {
    private BigInteger FriendsCount;
    private BigInteger FriendsOutRequest;
    private BigInteger friendsInRequest;
    private Iterable<Profile> friend_id;
    private Iterable<Profile> friend_out_id;
    private Iterable<Profile> friend_in_id;

    public CountsFriendsExt(BigInteger friendsCount, BigInteger friendsOutRequest, BigInteger friendsInRequest, Iterable<Profile> friend_id, Iterable<Profile> friend_out_id, Iterable<Profile> friend_in_id) {

        FriendsCount = friendsCount;
        FriendsOutRequest = friendsOutRequest;
        this.friendsInRequest = friendsInRequest;
        this.friend_id = friend_id;
        this.friend_out_id = friend_out_id;
        this.friend_in_id = friend_in_id;
    }

    public CountsFriendsExt()
    {

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

    public Iterable<Profile> getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Iterable<Profile> friend_id) {
        this.friend_id = friend_id;
    }

    public Iterable<Profile> getFriend_out_id() {


        return friend_out_id;
    }

    public void setFriend_out_id(Iterable<Profile> friend_out_id) {
        this.friend_out_id = friend_out_id;
    }

    public Iterable<Profile> getFriend_in_id() {
        return friend_in_id;
    }

    public void setFriend_in_id(Iterable<Profile> friend_in_id) {
        this.friend_in_id = friend_in_id;
    }
}

