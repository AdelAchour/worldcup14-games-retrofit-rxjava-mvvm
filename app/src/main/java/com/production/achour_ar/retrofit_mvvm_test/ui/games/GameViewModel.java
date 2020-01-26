package com.production.achour_ar.retrofit_mvvm_test.ui.games;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.production.achour_ar.retrofit_mvvm_test.data.GamesClient;
import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameViewModel extends ViewModel {

    public MutableLiveData<List<GameModel>> gameMLD = new MutableLiveData<>();
    private MutableLiveData<String> game = new MutableLiveData<>();

    public void getGames(){
        GamesClient.getInstance().getGames().enqueue(new Callback<List<GameModel>>() {
            @Override
            public void onResponse(Call<List<GameModel>> call, Response<List<GameModel>> response) {
                gameMLD.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<GameModel>> call, Throwable t) {
                game.setValue("Error!");
            }
        });
    }
}
