package com.project.dajver.dagger2testexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.dajver.dagger2testexample.adapter.MusicRecycleList;
import com.project.dajver.dagger2testexample.api.RestClient;
import com.project.dajver.dagger2testexample.api.model.GitHubModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<GitHubModel> {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    MusicRecycleList musicRecycleList;
    @Inject
    RestClient restClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recycleViewSetup(recyclerView);

        restClient.getService().getSearchedRepos("retrofit", 0, 100).enqueue(this);
    }

    public void recycleViewSetup(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onResponse(Call<GitHubModel> call, Response<GitHubModel> response) {
        GitHubModel githubModel = response.body() != null ? response.body() : new GitHubModel();
        musicRecycleList.addAll(githubModel.getItems());
        recyclerView.setAdapter(musicRecycleList);
    }

    @Override
    public void onFailure(Call<GitHubModel> call, Throwable t) {
        t.printStackTrace();
    }
}
