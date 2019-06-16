package ru.lubich.friendservice.model;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Евгений on 22.06.2017.
 */


public class UserLike {

    private BigInteger likes_count;
    private Iterable<Integer> user_id;

    public BigInteger getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(BigInteger likes_count) {
        this.likes_count = likes_count;
    }

    public Iterable<Integer> getUser_id() {
        return user_id;
    }

    public void setUser_id(Iterable<Integer> user_id) {
        this.user_id = user_id;
    }

    public UserLike(BigInteger likes_count, Iterable<Integer> user_id) {

        this.likes_count = likes_count;
        this.user_id = user_id;
    }
}
