package com.production.achour_ar.retrofit_mvvm_test.pojo;

public class TeamModel {

    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "TeamModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
