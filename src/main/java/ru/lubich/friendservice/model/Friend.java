package ru.lubich.friendservice.model;

/**
 * Created by Евгений on 21.06.2017.
 */


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;


@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "friendid", nullable = false)
    private Integer friendid;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Friend() {
    }

    public Friend(Integer userid, Integer friendid, Integer status) {
        this.userid = userid;
        this.friendid = friendid;
        this.status = 1;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        //Без подтверждения добавляем в друзья
        this.status = 1;
    }
}

