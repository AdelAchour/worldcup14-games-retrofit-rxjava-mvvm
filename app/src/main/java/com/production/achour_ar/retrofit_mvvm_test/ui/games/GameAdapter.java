package com.production.achour_ar.retrofit_mvvm_test.ui.games;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.production.achour_ar.retrofit_mvvm_test.R;
import com.production.achour_ar.retrofit_mvvm_test.data.ScoreManager;
import com.production.achour_ar.retrofit_mvvm_test.pojo.GameModel;
import com.production.achour_ar.retrofit_mvvm_test.pojo.TeamModel;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<GameModel> mylist = new ArrayList<>();
    private List<TeamModel> teamlist = new ArrayList<>();
    private Context mContext;

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GameViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        //populate views:
        holder.score1TV.setText(String.valueOf(mylist.get(position).getScore1()));
        holder.score2TV.setText(String.valueOf(mylist.get(position).getScore2()));
        holder.team1TV.setText(teamlist.get(mylist.get(position).getTeam1_id()-1).getTitle());
        holder.team2TV.setText(teamlist.get(mylist.get(position).getTeam2_id()-1).getTitle());
        holder.timeTV.setText(mylist.get(position).getPlay_At().substring(0,19));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("clicked : "+mylist.get(position).getScore1());
                int idWinner = ScoreManager.getWinner(mylist.get(position));
                if (idWinner > -1) {
                    String titleWinner = teamlist.get(idWinner - 1).getTitle();
                    System.out.println("winner : " + titleWinner);
                    Toast.makeText(mContext, "Winner : "+titleWinner, Toast.LENGTH_SHORT).show();
                }
                else {
                    System.out.println("draw after 90min !");
                    Toast.makeText(mContext, "Draw after 90min", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public void setList(Context context, List<GameModel> mylist, List<TeamModel> teamList) {
        this.mylist = mylist;
        this.teamlist = teamList;
        this.mContext = context;
        notifyDataSetChanged();
    }

    class GameViewHolder extends RecyclerView.ViewHolder {
        TextView team1TV, team2TV, score1TV, score2TV, timeTV;
        CardView cardView;

        GameViewHolder(@NonNull View itemView) {
            super(itemView);
            //binding:
            timeTV = itemView.findViewById(R.id.timeTV);
            team1TV = itemView.findViewById(R.id.team1TV);
            team2TV = itemView.findViewById(R.id.team2TV);
            score1TV = itemView.findViewById(R.id.score1TV);
            score2TV = itemView.findViewById(R.id.score2TV);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

