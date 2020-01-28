package com.production.achour_ar.retrofit_mvvm_test.data;

import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamesClient {
    private static final String BASE_URL = "https://montanaflynn-fifa-world-cup.p.rapidapi.com/";
    private GameInterface mInterface;
    private static GamesClient INSTANCE;

    private GamesClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mInterface = retrofit.create(GameInterface.class);
    }

    public static GamesClient getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GamesClient();
        }
        return INSTANCE;
    }

    public Observable<List<GameModel>> getGames(){
        return mInterface.getGames();
    }
}
