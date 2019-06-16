package ru.lubich.friendservice.model;

import java.math.BigInteger;

/**
 * Created by Евгений on 22.06.2017.
 */
public class CountsFriends {
    private BigInteger FriendsCount;
    private BigInteger FriendsOutRequest;
    private BigInteger friendsInRequest;

    public CountsFriends(BigInteger friendsCount, BigInteger friendsOutRequest, BigInteger friendsInrRequest) {
        FriendsCount = friendsCount;
        FriendsOutRequest = friendsOutRequest;
        this.friendsInRequest = friendsInrRequest;
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

    public void setFriendsInRequest(BigInteger friendsInrRequest) {
        this.friendsInRequest = friendsInrRequest;
    }
}
