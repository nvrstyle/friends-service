package ru.lubich.friendservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Евгений on 23.06.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
    private String email;
    private String login;
    private Integer uid;
    private String name;
    private String surname;

    public Profile(String email, String login, Integer uid, String name, String surname) {
        this.email = email;
        this.login = login;
        this.uid = uid;
        this.name = name;
        this.surname = surname;
    }

    public  Profile()
    {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
