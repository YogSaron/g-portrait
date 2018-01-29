package com.me.mybatis.entity;

import java.util.Date;

public class MeSysUserInfo {
    private Integer id;

    private String username;

    private Integer sex;

    private Integer year;

    private Integer day;

    private Integer month;

    private Integer hour;

    private String horoscopeYear;

    private String horoscopeMonth;

    private String horoscopeDay;

    private String horoscopeHour;

    private Integer calendar;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getHoroscopeYear() {
        return horoscopeYear;
    }

    public void setHoroscopeYear(String horoscopeYear) {
        this.horoscopeYear = horoscopeYear == null ? null : horoscopeYear.trim();
    }

    public String getHoroscopeMonth() {
        return horoscopeMonth;
    }

    public void setHoroscopeMonth(String horoscopeMonth) {
        this.horoscopeMonth = horoscopeMonth == null ? null : horoscopeMonth.trim();
    }

    public String getHoroscopeDay() {
        return horoscopeDay;
    }

    public void setHoroscopeDay(String horoscopeDay) {
        this.horoscopeDay = horoscopeDay == null ? null : horoscopeDay.trim();
    }

    public String getHoroscopeHour() {
        return horoscopeHour;
    }

    public void setHoroscopeHour(String horoscopeHour) {
        this.horoscopeHour = horoscopeHour == null ? null : horoscopeHour.trim();
    }

    public Integer getCalendar() {
        return calendar;
    }

    public void setCalendar(Integer calendar) {
        this.calendar = calendar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}