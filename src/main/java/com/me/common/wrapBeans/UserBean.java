package com.me.common.wrapBeans;

import java.io.Serializable;

/**
 * Created by Logan Zhou on 2018-01-25.
 */
public class UserBean implements Serializable{
    private String firstName;
    private String lastName;
    private Integer sex;
    private String birthday;
    private Integer hour;

    public UserBean(String firstName, String lastName, Integer sex, String birthday, Integer hour) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
        this.hour = hour;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }
}
