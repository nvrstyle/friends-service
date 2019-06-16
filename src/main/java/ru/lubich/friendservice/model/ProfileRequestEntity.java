package ru.lubich.friendservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created by Евгений on 23.06.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileRequestEntity {
    private String email;
    private String login;
    private Integer uid;
    private String name;
    private String surname;


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

    public ProfileRequestEntity() {
        this.email = "";
        this.login = "";
        this.uid = 0;
        this.name = "";
        this.surname = "";
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
}
