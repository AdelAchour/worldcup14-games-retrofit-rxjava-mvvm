package com.production.achour_ar.retrofit_mvvm_test.ui.games;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.production.achour_ar.retrofit_mvvm_test.data.GamesClient;
import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameViewModel extends ViewModel {

    private static final String TAG = "GameViewModel";
    public MutableLiveData<List<GameModel>> gameMLD = new MutableLiveData<>();
    private MutableLiveData<String> game = new MutableLiveData<>();

    public void getGames(){
        Observable observable = GamesClient.getInstance().getGames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<GameModel>> observer = new Observer<List<GameModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<GameModel> gameModels) {
                gameMLD.setValue(gameModels);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
            }

            @Override
            public void onComplete() {

            }
        };

        //observable.subscribe(o -> gameMLD.setValue(o), throwable -> Log.d(TAG, "getGames: onError - "+throwable));

        observable.subscribe(observer);
    }
}
