package com.project.dajver.dagger2testexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.dajver.dagger2testexample.R;
import com.project.dajver.dagger2testexample.api.model.GithubItemModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gleb on 8/16/17.
 */

public class MusicRecycleList extends RecyclerView.Adapter<MusicRecycleList.ViewHolder>{

    private List<GithubItemModel> searchModels = new ArrayList<>();

    @Inject
    public MusicRecycleList() { }

    public void addAll(List<GithubItemModel> searchModels) {
        this.searchModels = searchModels;
    }

    @Override
    public MusicRecycleList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        MusicRecycleList.ViewHolder pvh = new MusicRecycleList.ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final MusicRecycleList.ViewHolder holder, final int position) {
        holder.title.setText(searchModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return searchModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textView)
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}