package com.project.dajver.dagger2testexample.modules;

import android.app.Application;

import com.project.dajver.dagger2testexample.App;
import com.project.dajver.dagger2testexample.api.model.imp.FetchedDataPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gleb on 8/16/17.
 */

@Module
public class AppModule {

    private App app;

    public AppModule(App application) {
        app = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    FetchedDataPresenterImpl provideFetchedData() {
        return new FetchedDataPresenterImpl();
    }
}