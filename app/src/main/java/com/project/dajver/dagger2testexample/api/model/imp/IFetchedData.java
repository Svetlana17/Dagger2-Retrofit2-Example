package com.project.dajver.dagger2testexample.api.model.imp;

import com.project.dajver.dagger2testexample.api.model.GitHubItemModel;
import com.project.dajver.dagger2testexample.api.model.GitHubModel;

import java.util.List;

/**
 * Created by gleb on 8/18/17.
 */

public interface IFetchedData {

    void setGitHubData(GitHubModel data);
    List<GitHubItemModel> getAllData();
    GitHubItemModel getGitHubData(int position);
}
