package com.production.achour_ar.retrofit_mvvm_test.pojo;

public class GameModel {
    private int id;
    private int round_id;
    private int team1_id;
    private int team2_id;
    private int score1;
    private int score2;
    private String play_at;

    public int getId() {
        return id;
    }

    public int getRound_id() {
        return round_id;
    }

    public int getTeam1_id() {
        return team1_id;
    }

    public int getTeam2_id() {
        return team2_id;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public String getPlay_At() {
        return play_at;
    }

    @Override
    public String toString() {
        return "GameModel{" +
                "id=" + id +
                ", round_id=" + round_id +
                ", team1_id=" + team1_id +
                ", team2_id=" + team2_id +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", play_at='" + play_at + '\'' +
                '}';
    }
}
