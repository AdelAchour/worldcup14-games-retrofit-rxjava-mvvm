package com.production.achour_ar.retrofit_mvvm_test.ui.teams;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.production.achour_ar.retrofit_mvvm_test.data.TeamsClient;
import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;
import com.production.achour_ar.retrofit_mvvm_test.pojo.TeamModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamViewModel extends ViewModel {

    private static final String TAG = "TeamViewModel";
    MutableLiveData<List<TeamModel>> teamsMLD = new MutableLiveData<>();
    private MutableLiveData<String> team = new MutableLiveData<>();

    public void getTeams() {
        Observable<List<TeamModel>> observable = TeamsClient.getInstance().getTeams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(o -> teamsMLD.setValue(o), e-> Log.d(TAG, "onError: "+e));

    }
}
