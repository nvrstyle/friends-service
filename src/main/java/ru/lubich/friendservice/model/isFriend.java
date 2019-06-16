package ru.lubich.friendservice.model;

/**
 * Created by Евгений on 22.06.2017.
 */
public class isFriend {
    private Integer friended;

    public isFriend(Integer friended) {
        this.friended = friended;
    }

    public Integer getFriended() {
        return friended;
    }

    public void setFriended(Integer friended) {
        this.friended= friended;
    }
}
