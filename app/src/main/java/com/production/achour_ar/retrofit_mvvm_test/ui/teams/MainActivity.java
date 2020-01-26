package com.production.achour_ar.retrofit_mvvm_test.ui.teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.production.achour_ar.retrofit_mvvm_test.R;
import com.production.achour_ar.retrofit_mvvm_test.databinding.ActivityMainBinding;
import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;
import com.production.achour_ar.retrofit_mvvm_test.pojo.TeamModel;
import com.production.achour_ar.retrofit_mvvm_test.ui.games.GameAdapter;
import com.production.achour_ar.retrofit_mvvm_test.ui.games.GameViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TeamViewModel teamVM;
    private GameViewModel gameVM;
    private TeamAdapter adapter;
    private GameAdapter adapterGame;
    private List<TeamModel> listTeams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        //setupRVteams();
        setupRVgames();
        setupVMgames();
        setupVM();

    }

    private void setupRVgames() {
        adapterGame = new GameAdapter();
        binding.recyclergames.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclergames.setAdapter(adapterGame);
    }

    private void setupVMgames() {
        gameVM = ViewModelProviders.of(this).get(GameViewModel.class);
        binding.setViewModelGame(gameVM);

        gameVM.gameMLD.observe(this, gameModels -> {
            setupRVgames();
            adapterGame.setList(MainActivity.this, gameModels, listTeams);
            /*for (GameModel game : gameModels){
            System.out.println(game);
            }*/
        });
    }

    private void setupVM() {
        teamVM = ViewModelProviders.of(this).get(TeamViewModel.class);
        binding.setViewModelTeam(teamVM);
        teamVM.getTeams();

        teamVM.teamsMLD.observe(this, teamModels -> {
            listTeams = teamModels;
            binding.teamsButton.setEnabled(true);
            binding.progressBar.setVisibility(View.GONE);
            binding.teamsButton.setText("GET GAMES !");
            binding.teamsButton.setTextColor(getResources().getColor(R.color.blueBrazil));
            System.out.println("ready !");
            /*for (TeamModel team : teamModels){
                System.out.println(team);
            }*/
        });
    }

    private void setupRVteams() {
        adapter = new TeamAdapter();
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);
    }
}
