package com.production.achour_ar.retrofit_mvvm_test.ui.teams;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.production.achour_ar.retrofit_mvvm_test.data.TeamsClient;
import com.production.achour_ar.retrofit_mvvm_test.pojo.TeamModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamViewModel extends ViewModel {

    MutableLiveData<List<TeamModel>> teamsMLD = new MutableLiveData<>();
    private MutableLiveData<String> team = new MutableLiveData<>();

    public void getTeams(){
        TeamsClient.getInstance().getTeams().enqueue(new Callback<List<TeamModel>>() {
            @Override
            public void onResponse(Call<List<TeamModel>> call, Response<List<TeamModel>> response) {
                System.out.println("res: "+response);
                teamsMLD.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TeamModel>> call, Throwable t) {
                System.out.println("error!");
                team.setValue("error");
            }
        });
    }
}
