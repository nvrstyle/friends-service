package ru.lubich.friendservice.model;

/**
 * Created by Евгений on 24.06.2017.
 */
public class RequestProfile {
    Iterable<Integer> uid;

    public RequestProfile()
    {

    }

    public RequestProfile(Iterable<Integer> uid) {
        this.uid = uid;
    }

    public Iterable<Integer> getUid() {
        return uid;
    }

    public void setUid(Iterable<Integer> uid) {
        this.uid = uid;
    }
}
