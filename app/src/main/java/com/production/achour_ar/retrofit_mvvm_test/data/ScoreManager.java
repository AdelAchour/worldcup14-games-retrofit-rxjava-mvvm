package com.production.achour_ar.retrofit_mvvm_test.data;

import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;
import com.production.achour_ar.retrofit_mvvm_test.pojo.TeamModel;

public class ScoreManager {
    public static int getWinner(GameModel game){
        if (game.getScore1() > game.getScore2()){
            return game.getTeam1_id();
        }
        else if (game.getScore1() < game.getScore2()){
            return game.getTeam2_id();
        }
        else {
            return -1;
        }
    }
}
