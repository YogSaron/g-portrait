package com.me.mybatis.entity;

public class MeSysPortraitInfo {
    private Integer id;

    private String portraitName;

    private Integer star;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPortraitName() {
        return portraitName;
    }

    public void setPortraitName(String portraitName) {
        this.portraitName = portraitName == null ? null : portraitName.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}