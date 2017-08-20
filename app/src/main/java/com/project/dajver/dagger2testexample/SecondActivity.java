package com.project.dajver.dagger2testexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.project.dajver.dagger2testexample.api.model.imp.FetchedDataPresenterImpl;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by gleb on 8/18/17.
 */

public class SecondActivity extends AppCompatActivity {

    @Inject
    FetchedDataPresenterImpl fetchedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        App.component().inject(this);

        Log.e("sdfsdf", "" + fetchedData.getGitHubData(0).getName());
    }
}
