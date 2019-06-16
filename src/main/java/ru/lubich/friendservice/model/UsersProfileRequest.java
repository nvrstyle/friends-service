package ru.lubich.friendservice.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Евгений on 26.06.2017.
 */
public class UsersProfileRequest {
    private Iterable<Profile> users;

    public UsersProfileRequest()
    {

    }

    public UsersProfileRequest(Iterable<Profile> users) {
        this.users = users;
    }

    public Iterable<Profile> getUsers() {
        return users;
    }

    public void setUsers(Iterable<Profile> users) {
        this.users = users;
    }
}
