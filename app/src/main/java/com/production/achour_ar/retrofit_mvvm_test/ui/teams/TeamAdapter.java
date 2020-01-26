package com.production.achour_ar.retrofit_mvvm_test.ui.teams;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.production.achour_ar.retrofit_mvvm_test.R;
import com.production.achour_ar.retrofit_mvvm_test.pojo.TeamModel;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<TeamModel> teamList = new ArrayList<>();

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.titleTV.setText(teamList.get(position).getTitle());
        holder.idTV.setText(String.valueOf(teamList.get(position).getId()));
    }
    @Override
    public int getItemCount() {
        return teamList.size();
    }
    public void setList(List<TeamModel> teamList) {
        this.teamList = teamList;
        notifyDataSetChanged();
    }
    class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, idTV;
        TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            idTV = itemView.findViewById(R.id.idTV);
        }
    }
}

