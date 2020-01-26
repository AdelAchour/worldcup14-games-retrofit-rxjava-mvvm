package com.production.achour_ar.retrofit_mvvm_test.data;

import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GameInterface {

    @Headers({
            "X-RapidAPI-Host: montanaflynn-fifa-world-cup.p.rapidapi.com",
            "X-RapidAPI-Key: 1c0f66b2b1msh432d530e3c1693ap1578d7jsna997dc6ae7ee"
    })
    @GET("games")
    Call<List<GameModel>> getGames();
}
