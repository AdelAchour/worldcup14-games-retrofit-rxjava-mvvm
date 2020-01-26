package com.production.achour_ar.retrofit_mvvm_test.data;

import com.production.achour_ar.retrofit_mvvm_test.pojo.TeamModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamsClient {

    private static final String BASE_URL = "https://montanaflynn-fifa-world-cup.p.rapidapi.com/";
    private TeamInterface teamInterface;
    private static TeamsClient INSTANCE;

    private TeamsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        teamInterface = retrofit.create(TeamInterface.class);
    }

    public static TeamsClient getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TeamsClient();
        }
        return INSTANCE;
    }

    public Call<List<TeamModel>> getTeams(){
        return teamInterface.getTeams();
    }
}
